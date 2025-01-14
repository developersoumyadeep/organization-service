package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.AggregateRoot;
import in.falconworks.orgservice.domain.common.model.UserId;
import in.falconworks.orgservice.domain.hr.event.AddressChangedEvent;
import in.falconworks.orgservice.domain.hr.event.EmailChangedEvent;
import in.falconworks.orgservice.domain.hr.event.MobileNumberChangedEvent;
import in.falconworks.orgservice.domain.hr.event.OutsourcedEmployeeCreatedEvent;
import in.falconworks.orgservice.domain.hr.exception.EmployeeValidationException;

import java.time.LocalDate;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class OutsourcedEmployeeAggregate implements AggregateRoot {
    private final UserId userId;
    private final PersonName personName;
    private final LocalDate dateOfBirth;
    private ContactDetails contactDetails;
    private final Position currentPosition;
    private final UserId vendorId;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public MobileNumberChangedEvent updateMobile(String newMobileNumber) {
        logger.info("Updating mobile number of outsourced employee "+userId+" ("+personName.getFullName()+")");
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
        logger.info("Updating email of outsourced employee "+userId+" ("+personName.getFullName()+")");
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
        logger.info("Updating address of outsourced employee "+userId+" ("+personName.getFullName()+")");
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

    public OutsourcedEmployeeState getState() {
        return OutsourcedEmployeeState.builder()
                .userId(userId)
                .firstName(personName.firstName())
                .lastName(personName.lastName())
                .dateOfBirth(dateOfBirth)
                .address(contactDetails.address())
                .email(contactDetails.email())
                .mobile(contactDetails.mobile())
                .position(currentPosition)
                .vendorId(vendorId)
                .build();
    }

    public OutsourcedEmployeeCreatedEvent validateAndInitiate() {
        validate();
        return new OutsourcedEmployeeCreatedEvent(getState());
    }

    private void validate() {
        if (userId == null) {
            throw new EmployeeValidationException("Outsourced employee must have valid user id");
        }
        logger.info("Validating outsourced employee with id "+userId);
        personName.validate();
        validateDateOfBirth();
        validateCurrentPosition();
        contactDetails.validate();
        logger.info("Outsourced employee "+userId+" successfully validated");
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

    private void validateDateOfBirth() {
        logger.info("Validating date of birth");
        if (dateOfBirth == null) {
            throw new EmployeeValidationException("Outsourced employee "+userId+"( "+personName.getFullName()+")"+
                    " must have a valid date of birth");
        }
        if (!(dateOfBirth.plusYears(18).isBefore(LocalDate.now())) ||
                dateOfBirth.plusYears(18).isEqual(LocalDate.now())) {
            throw new EmployeeValidationException("Outsourced employee "+userId+"( "+personName.getFullName()+")"+
                    " age can not be below 18 years");
        }
    }

    private OutsourcedEmployeeAggregate(Builder builder) {
        userId = builder.userId;
        personName = new PersonName(builder.firstName, builder.lastName);
        dateOfBirth = builder.dateOfBirth;
        contactDetails = new ContactDetails(builder.mobile, builder.email, builder.address);
        currentPosition = builder.position;
        currentPosition.fillPosition(userId);
        vendorId = builder.vendorId;
    }
    
    public static class Builder {
        private UserId userId;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private Address address;
        private String mobile;
        private String email;
        private Position position;
        private UserId vendorId;

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

        public Builder position(Position position) {
            this.position = position;
            return this;
        }

        public Builder vendorId(UserId vendorId) {
            this.vendorId = vendorId;
            return this;
        }

        public OutsourcedEmployeeAggregate build() {
            return new OutsourcedEmployeeAggregate(this);
        }
    }
}
