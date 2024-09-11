package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.AggregateRoot;
import in.falconworks.orgservice.domain.common.model.PositionId;
import in.falconworks.orgservice.domain.common.model.UserId;
import in.falconworks.orgservice.hr.domain.core.event.*;
import in.falconworks.orgservice.hr.domain.core.exception.EmployeeValidationException;

import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Logger;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class RegularEmployee implements AggregateRoot {
    private final UserId userId;
    private final PersonName personName;
    private final LocalDate dateOfBirth;
    private final LocalDate dateOfJoiningAtService;
    private ContactDetails contactDetails;
    private Designation currentDesignation;
    private Position currentPosition;
    private RetirementDetail retirementDetail;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public DesignationChangedEvent updateDesignation(Designation newDesignation) {
        logger.info("Updating designation for regular employee "+userId+" ("+personName.getFullName()+")");
        Designation lastDesignation = currentDesignation;
        this.currentDesignation = newDesignation;
        validate();
        DesignationChangeData data = DesignationChangeData.builder()
                .userId(userId)
                .firstName(personName.firstName())
                .lastName(personName.lastName())
                .lastDesignation(lastDesignation)
                .newDesignation(newDesignation)
                .dateOfDesignationChange(LocalDate.now())
                .build();
        return new DesignationChangedEvent(data);
    }

    public PositionChangedEvent updatePosition(Position newPosition) {
        logger.info("Updating position for regular employee "+userId+" ("+personName.getFullName()+")");
        PositionId lastPositionId = currentPosition.getPositionId();
        this.currentPosition = newPosition;
        validate();
        PositionChangeData positionChangeData = PositionChangeData.builder()
                .userId(userId)
                .firstName(personName.firstName())
                .lastName(personName.lastName())
                .newPositionId(newPosition.getPositionId())
                .lastPositionId(lastPositionId)
                .dateOfPositionChange(LocalDate.now())
                .build();
        return new PositionChangedEvent(positionChangeData);
    }

    public EmployeeRetiredEvent executeRetirement() {
        logger.info("Executing retirement action on employee "+userId+" ("+personName.getFullName()+")");
        this.retirementDetail = new RetirementDetail(true, LocalDate.now());
        validate();
        EmployeeRetirementData data = EmployeeRetirementData.builder()
                .userId(userId)
                .firstName(personName.firstName())
                .lastName(personName.lastName())
                .dateOfRetirement(retirementDetail.dateOfRetirement())
                .designationBeforeRetirement(currentDesignation)
                .yearOfService(Period.between(dateOfJoiningAtService, retirementDetail.dateOfRetirement()).getYears())
                .build();
        return new EmployeeRetiredEvent(data);
    }

    public MobileNumberChangedEvent updateMobile(String newMobileNumber) {
        logger.info("Updating mobile number for regular employee "+userId+" ("+personName.getFullName()+")");
        this.contactDetails = new ContactDetails(newMobileNumber, contactDetails.email(),
                contactDetails.address());
        validate();
        ContactDetailsChangeData contactDetailsChangeData = ContactDetailsChangeData.builder()
                .userId(userId)
                .firstName(personName.firstName())
                .lastName(personName.lastName())
                .newContactDetails(this.contactDetails)
                .build();
        return new MobileNumberChangedEvent(contactDetailsChangeData);
    }

    public EmailChangedEvent updateEmail(String newEmail) {
        logger.info("Updating email for regular employee "+userId+" ("+personName.getFullName()+")");
        this.contactDetails = new ContactDetails(contactDetails.mobile(), newEmail,
                contactDetails.address());
        validate();
        ContactDetailsChangeData contactDetailsChangeData = ContactDetailsChangeData.builder()
                .userId(userId)
                .firstName(personName.firstName())
                .lastName(personName.lastName())
                .newContactDetails(this.contactDetails)
                .build();
        return new EmailChangedEvent(contactDetailsChangeData);
    }

    public AddressChangedEvent updateAddress(Address newAddress) {
        logger.info("Updating address for regular employee "+userId+" ("+personName.getFullName()+")");
        this.contactDetails = new ContactDetails(contactDetails.mobile(), contactDetails.email(),
                newAddress);
        validate();
        ContactDetailsChangeData contactDetailsChangeData = ContactDetailsChangeData.builder()
                .userId(userId)
                .firstName(personName.firstName())
                .lastName(personName.lastName())
                .newContactDetails(this.contactDetails)
                .build();
        return new AddressChangedEvent(contactDetailsChangeData);
    }

    public RegularEmployeeState getState() {
        return RegularEmployeeState.builder()
                .userId(userId)
                .firstName(personName.firstName())
                .lastName(personName.lastName())
                .dateOfBirth(dateOfBirth)
                .dateOfJoiningAtService(dateOfJoiningAtService)
                .address(contactDetails.address())
                .email(contactDetails.email())
                .mobile(contactDetails.mobile())
                .designation(currentDesignation)
                .position(currentPosition)
                .isRetired(retirementDetail.isRetired())
                .dateOfRetirement(retirementDetail.dateOfRetirement())
                .build();
    }

    @Override
    public String toString() {
        return personName.getFullName()+","+currentDesignation.name();
    }

    public RegularEmployeeCreatedEvent validateAndInitialize() {
        validate();
        return new RegularEmployeeCreatedEvent(getState());
    }

    private void validate() {
        if (userId == null) {
            throw new EmployeeValidationException("Employee must have valid user id");
        }
        logger.info("Validating regular employee "+userId);
        personName.validate();
        validateDateOfBirth();
        validateDesignation();
        contactDetails.validate();
        validateCurrentPosition();
        retirementDetail.validate();
        validateRetirementStatus();
        logger.info("Regular employee "+userId+" ("+personName.getFullName()+") validated");
    }

    private void validateCurrentPosition() {
        logger.info("Validating current position");
        if (currentPosition.isVacant()) {
            throw new EmployeeValidationException("Employee position found vacant. It should have been filled up by the employee");
        }
        if (!currentPosition.getEmployeeUserId().get().equals(userId)) {
            throw new EmployeeValidationException("Employee position is filled up with incorrect user id");
        }
    }

    private void validateRetirementStatus() {
        logger.info("Validating retirement status");
        if ((LocalDate.now().isAfter(dateOfBirth.plusYears(60)) ||
                LocalDate.now().isEqual(dateOfBirth.plusYears(60))) && !retirementDetail.isRetired()) {
            throw new EmployeeValidationException("Employee of age 60 and above should be retired");
        }
        logger.info("Retirement status validated");
    }

    private void validateDesignation() {
        logger.info("Validating designation");
        if (currentDesignation == null) {
            throw new EmployeeValidationException("Regular employee "+userId+"( "
                    +personName.getFullName()+") must have a valid designation");
        }
        logger.info("Designation validated");
    }

    private void validateDateOfBirth() {
        logger.info("Validating date of birth");
        if (dateOfBirth == null) {
            throw new EmployeeValidationException("Regular employee "+userId+"( "
                    +personName.getFullName()+") must have a valid date of birth");
        }
        if (!(dateOfBirth.plusYears(18).isBefore(LocalDate.now())) ||
                dateOfBirth.plusYears(18).isEqual(LocalDate.now())) {
            throw new EmployeeValidationException("Regular employee "+userId+"( "
                    +personName.getFullName()+") can not have age below 18 years");
        }
        logger.info("Date of birth validated");
    }

    private RegularEmployee(Builder builder) {
        userId = builder.userId;
        personName = new PersonName(builder.firstName, builder.lastName);
        dateOfBirth = builder.dateOfBirth;
        dateOfJoiningAtService = builder.dateOfJoiningAtService;
        contactDetails = new ContactDetails(builder.mobile, builder.email, builder.address);
        currentDesignation = builder.designation;
        currentPosition = builder.position;
        currentPosition.fillPosition(userId);
        retirementDetail = new RetirementDetail(builder.isRetired, builder.dateOfRetirement);
    }

    public static Builder builder() {
        return new Builder();
    }

    @SuppressWarnings("FieldCanBeLocal")
    public static class Builder {
        private UserId userId;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private LocalDate dateOfJoiningAtService;
        private Address address;
        private String mobile;
        private String email;
        private Designation designation;
        private Position position;
        private boolean isRetired;
        private LocalDate dateOfRetirement;

        private Builder() {
        }

        public Builder userId(UserId userId) {
            this.userId = userId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder dateOfJoiningAtService(LocalDate dateOfJoiningAtService) {
            this.dateOfJoiningAtService = dateOfJoiningAtService;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder designation(Designation designation) {
            this.designation = designation;
            return this;
        }

        public Builder position(Position position) {
            this.position = position;
            return this;
        }

        public Builder isRetired(boolean isRetired) {
            this.isRetired = isRetired;
            return this;
        }

        public Builder dateOfRetirement(LocalDate dateOfRetirement) {
            this.dateOfRetirement = dateOfRetirement;
            return this;
        }

        public RegularEmployee build() {
            return new RegularEmployee(this);
        }
    }

}

