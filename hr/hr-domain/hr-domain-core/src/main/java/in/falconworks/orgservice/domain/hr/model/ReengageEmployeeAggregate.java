package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.AggregateRoot;
import in.falconworks.orgservice.domain.common.model.UserId;
import in.falconworks.orgservice.domain.establishment.model.Position;
import in.falconworks.orgservice.domain.hr.exception.EmployeeValidationException;

import java.time.LocalDate;
import java.util.logging.Logger;

@SuppressWarnings("FieldCanBeLocal")
public class ReengageEmployeeAggregate implements AggregateRoot {
    private final UserId userId;
    private final PersonName personName;
    private ContactDetails contactDetails;
    private final LocalDate dateOfBirth;
    private final Designation lastDesignationBeforeRetirement;
    private Position currentPosition;
    private final RetirementDetail retirementDetail;
    private CurrentContractDetail currentContractDetail;
    private final Logger logger = Logger.getLogger(getClass().getName());

    //Expire reengagement contract
    public void expireContract() {
        logger.info("Expiring contract for reengaged employee "+userId+" ("+personName.getFullName()+")");
        if (!currentContractDetail.contractExpired()) {
            currentContractDetail = new CurrentContractDetail(currentContractDetail.startDateOfCurrentContract(), LocalDate.now());
        }
    }

    //Get date of attaining maximum allowable age for reengagement
    public LocalDate dateOfMaxAgeForReengagement() {
        return dateOfBirth.plusYears(CurrentContractDetail.MAX_AGE_FOR_REENGAGEMENT_VALIDITY);
    }

    //Get date of reengagement contract expiry
    public LocalDate dateOfCurrentContractExpiry() {
        return currentContractDetail.dateOfCurrentContractExpiry();
    }

    //Get current reengagement status
    public boolean contractExpired() {
        return currentContractDetail.contractExpired();
    }

    public UserId getUserId() {
        return this.userId;
    }

    public String getFullName() {
        return personName.getFullName();
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

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void updatePosition(Position newPosition) {
        logger.info("Updating position for reengaged employee "+userId+" ("+personName.getFullName()+")");
        this.currentPosition = newPosition;
        validate();
    }

    public LocalDate getRetirementDate() {
        return this.retirementDetail.dateOfRetirement();
    }

    public void updateMobile(String newMobileNumber) {
        logger.info("Updating mobile number for reengaged employee "+userId+" ("+personName.getFullName()+")");
        this.contactDetails = new ContactDetails(newMobileNumber, contactDetails.email(),
                contactDetails.address());
        validate();
    }

    public void updateEmail(String newEmail) {
        logger.info("Updating email for reengaged employee "+userId+" ("+personName.getFullName()+")");
        this.contactDetails = new ContactDetails(contactDetails.mobile(), newEmail,
                contactDetails.address());
        validate();
    }

    public void updateAddress(Address newAddress) {
        logger.info("Updating address for reengaged employee "+userId+" ("+personName.getFullName()+")");
        this.contactDetails = new ContactDetails(contactDetails.mobile(), contactDetails.email(),
                newAddress);
        validate();
    }

    public ReengagedEmployeeState getState() {
        return ReengagedEmployeeState.builder()
                .userId(userId)
                .firstName(personName.firstName())
                .lastName(personName.lastName())
                .dateOfBirth(dateOfBirth)
                .address(getAddress())
                .email(getEmail())
                .mobile(getMobileNumber())
                .lastDesignation(lastDesignationBeforeRetirement)
                .position(currentPosition)
                .dateOfRetirement(getRetirementDate())
                .startDateOfCurrentContract(currentContractDetail.startDateOfCurrentContract())
                .dateOfCurrentContractExpiry(currentContractDetail.dateOfCurrentContractExpiry())
                .build();
    }


    public void validate() {
        if (userId == null) {
            throw new EmployeeValidationException("Employee must have valid user id");
        }
        logger.info("Validating reengaged employee with id "+userId);
        personName.validate();
        validateDateOfBirth();
        validateDesignation();
        contactDetails.validate();
        retirementDetail.validate();
        validateRetirementStatus();
        validateReengagementStatus();
        logger.info("Reengaged employee "+userId+" successfully validated");
    }

    private void validateReengagementStatus() {
        if (currentContractDetail.startDateOfCurrentContract().isBefore(retirementDetail.dateOfRetirement())) {
            throw new EmployeeValidationException("Reengaged employee "+userId+"( "+ personName.getFullName()+" )"+
                    " has date of re-engagement before date of retirement");
        }
    }

    private void validateRetirementStatus() {
        logger.info("Validating retirement status");
        if (!retirementDetail.isRetired() || retirementDetail.dateOfRetirement() == null) {
            throw new EmployeeValidationException("Reengaged employee "+userId+"( "+ personName.getFullName()+" )"+
                    " must be a retired employee with valid retirement date");
        }
        if (dateOfBirth.plusYears(60).isBefore(retirementDetail.dateOfRetirement())) {
            throw new EmployeeValidationException("Reengaged employee "+userId+"( "+ personName.getFullName()+" )"+
                    " has an invalid retirement status. " +
                    "Difference between date of birth and date of retirement must be equal to or more than 60 years");
        }
    }

    private void validateDesignation() {
        logger.info("Validating designation");
        if (lastDesignationBeforeRetirement == null) {
            throw new EmployeeValidationException("Reengaged employee "+userId+"( "+ personName.getFullName()+" )"+
                    " must have a valid designation before retirement");
        }
    }

    private void validateDateOfBirth() {
        logger.info("Validating date of birth");
        if (dateOfBirth == null) {
            throw new EmployeeValidationException("Employee "+userId+"( "+ personName.getFullName()+" )"+
                    " must have a valid date of birth");
        }
        if (!(dateOfBirth.plusYears(18).isBefore(LocalDate.now())) ||
                dateOfBirth.plusYears(18).isEqual(LocalDate.now())) {
            throw new EmployeeValidationException("Employee "+userId+"( "+ personName.getFullName()+" )"+
                    " can not be below 18 years");
        }
    }

    private ReengageEmployeeAggregate(Builder builder) {
        userId = builder.userId;
        personName = new PersonName(builder.firstName, builder.lastName);
        dateOfBirth = builder.dateOfBirth;
        contactDetails = new ContactDetails(builder.mobile, builder.email, builder.address);
        lastDesignationBeforeRetirement = builder.lastDesignation;
        currentPosition = builder.position;
        retirementDetail = new RetirementDetail(true, builder.dateOfRetirement);
        currentContractDetail = new CurrentContractDetail(builder.startDateOfCurrentContract, builder.dateOfCurrentContractExpiry);
    }

    public static class Builder {
        private UserId userId;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private Address address;
        private String mobile;
        private String email;
        private Designation lastDesignation;
        private Position position;
        private boolean isRetired;
        private LocalDate dateOfRetirement;
        private LocalDate startDateOfCurrentContract;
        private LocalDate dateOfCurrentContractExpiry;

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

        public Builder lastDesignation(Designation lastDesignation) {
            this.lastDesignation = lastDesignation;
            return this;
        }

        public Builder position(Position position) {
            this.position = position;
            return this;
        }

        public Builder dateOfRetirement(LocalDate dateOfRetirement) {
            this.dateOfRetirement = dateOfRetirement;
            return this;
        }

        public Builder startDateOfCurrentContract(LocalDate startDateOfCurrentContract) {
            this.startDateOfCurrentContract = startDateOfCurrentContract;
            return this;
        }

        public Builder dateOfCurrentContract(LocalDate dateOfCurrentContractExpiry) {
            this.dateOfCurrentContractExpiry = dateOfCurrentContractExpiry;
            return this;
        }

        public  ReengageEmployeeAggregate build() {
            return new ReengageEmployeeAggregate(this);
        }
    }
}

