package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.AggregateRoot;
import in.falconworks.orgservice.domain.common.model.UserId;
import in.falconworks.orgservice.domain.establishment.model.Position;
import in.falconworks.orgservice.domain.hr.exception.EmployeeValidationException;

import java.time.LocalDate;
import java.util.logging.Logger;

@SuppressWarnings("FieldCanBeLocal")
public class RegularEmployeeAggregate implements AggregateRoot {
    private final UserId userId;
    private final PersonName personName;
    private final LocalDate dateOfBirth;
    private ContactDetails contactDetails;
    private Designation currentDesignation;
    private Position currentPosition;
    private RetirementDetail retirementDetail;
    private final Logger logger = Logger.getLogger(getClass().getName());


    public UserId getUserId() {
        return this.userId;
    }

    public String getFullName() {
        return personName.getFullName();
    }

    public void updateDesignation(Designation newDesignation) {
        logger.info("Updating designation for regular employee "+userId+" ("+personName.getFullName()+")");
        this.currentDesignation = newDesignation;
        validate();
    }

    public void updatePosition(Position newPosition) {
        logger.info("Updating position for regular employee "+userId+" ("+personName.getFullName()+")");
        this.currentPosition = newPosition;
        validate();
    }

    public void executeRetirement() {
        logger.info("Executing retirement action on employee "+userId+" ("+personName.getFullName()+")");
        this.retirementDetail = new RetirementDetail(true, LocalDate.now());
        validate();
    }

    public boolean isRetired() {
        return this.retirementDetail.isRetired();
    }

    public LocalDate getRetirementDate() {
        return this.retirementDetail.dateOfRetirement();
    }

    public String getMobileNumber() {
        return contactDetails.mobile();
    }

    public String getEmail() {
        return contactDetails.email();
    }

    public Address getAddress() {
        return contactDetails.address();
    }

    public void updateMobile(String newMobileNumber) {
        logger.info("Updating mobile number for regular employee "+userId+" ("+personName.getFullName()+")");
        this.contactDetails = new ContactDetails(newMobileNumber, contactDetails.email(),
                contactDetails.address());
        validate();
    }

    public void updateEmail(String newEmail) {
        logger.info("Updating email for regular employee "+userId+" ("+personName.getFullName()+")");
        this.contactDetails = new ContactDetails(contactDetails.mobile(), newEmail,
                contactDetails.address());
        validate();
    }

    public void updateAddress(Address newAddress) {
        logger.info("Updating address for regular employee "+userId+" ("+personName.getFullName()+")");
        this.contactDetails = new ContactDetails(contactDetails.mobile(), contactDetails.email(),
                newAddress);
        validate();
    }

    public RegularEmployeeState getState() {
        return RegularEmployeeState.builder()
                .userId(userId)
                .firstName(personName.firstName())
                .lastName(personName.lastName())
                .dateOfBirth(dateOfBirth)
                .address(getAddress())
                .email(getEmail())
                .mobile(getMobileNumber())
                .designation(currentDesignation)
                .position(currentPosition)
                .isRetired(isRetired())
                .dateOfRetirement(getRetirementDate())
                .build();
    }

    @Override
    public String toString() {
        return getFullName()+","+currentDesignation.name();
    }

    public void validate() {
        if (userId == null) {
            throw new EmployeeValidationException("Employee must have valid user id");
        }
        logger.info("Validating regular employee "+userId);
        personName.validate();
        validateDateOfBirth();
        validateDesignation();
        contactDetails.validate();
        retirementDetail.validate();
        validateRetirementStatus();
        logger.info("Regular employee "+userId+" ("+personName.getFullName()+") validated");
    }

    private void validateRetirementStatus() {
        logger.info("Validating retirement status");
        if ((LocalDate.now().isAfter(dateOfBirth.plusYears(60)) ||
                LocalDate.now().isEqual(dateOfBirth.plusYears(60))) && !isRetired()) {
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

    private RegularEmployeeAggregate(Builder builder) {
        userId = builder.userId;
        personName = new PersonName(builder.firstName, builder.lastName);
        dateOfBirth = builder.dateOfBirth;
        contactDetails = new ContactDetails(builder.mobile, builder.email, builder.address);
        currentDesignation = builder.designation;
        currentPosition = builder.position;
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

        public RegularEmployeeAggregate build() {
            return new RegularEmployeeAggregate(this);
        }
    }

}

