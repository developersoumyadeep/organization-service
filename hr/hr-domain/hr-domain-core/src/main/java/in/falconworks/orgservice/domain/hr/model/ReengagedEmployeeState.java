package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.UserId;
import in.falconworks.orgservice.domain.establishment.model.Position;

import java.time.LocalDate;

public class ReengagedEmployeeState {
    private final UserId userId;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Address address;
    private final String mobile;
    private final String email;
    private final Designation lastDesignation;
    private final Position position;
    private final LocalDate dateOfRetirement;
    private final LocalDate startDateOfCurrentContract;
    private final LocalDate dateOfCurrentContractExpiry;

    private ReengagedEmployeeState(Builder builder) {
        userId = builder.userId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        dateOfBirth = builder.dateOfBirth;
        address = builder.address;
        mobile = builder.mobile;
        email = builder.email;
        lastDesignation = builder.lastDesignation;
        position = builder.position;

        dateOfRetirement = builder.dateOfRetirement;
        startDateOfCurrentContract = builder.startDateOfCurrentContract;
        dateOfCurrentContractExpiry = builder.dateOfCurrentContractExpiry;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserId userId;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private Address address;
        private String mobile;
        private String email;
        private Designation lastDesignation;
        private Position position;
        private LocalDate dateOfRetirement;
        private LocalDate startDateOfCurrentContract;
        private LocalDate dateOfCurrentContractExpiry;

        private Builder() {
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder dateOfBirth(LocalDate val) {
            dateOfBirth = val;
            return this;
        }

        public Builder address(Address val) {
            address = val;
            return this;
        }

        public Builder mobile(String val) {
            mobile = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder lastDesignation(Designation val) {
            lastDesignation = val;
            return this;
        }

        public Builder position(Position val) {
            position = val;
            return this;
        }

        public Builder dateOfRetirement(LocalDate val) {
            dateOfRetirement = val;
            return this;
        }

        public Builder startDateOfCurrentContract(LocalDate val) {
            startDateOfCurrentContract = val;
            return this;
        }

        public Builder dateOfCurrentContractExpiry(LocalDate val) {
            dateOfCurrentContractExpiry = val;
            return this;
        }

        public ReengagedEmployeeState build() {
            return new ReengagedEmployeeState(this);
        }
    }

    public UserId getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public Designation getLastDesignation() {
        return lastDesignation;
    }

    public Position getPosition() {
        return position;
    }

    public LocalDate getDateOfRetirement() {
        return dateOfRetirement;
    }

    public LocalDate getStartDateOfCurrentContract() {
        return startDateOfCurrentContract;
    }

    public LocalDate getDateOfCurrentContractExpiry() {
        return dateOfCurrentContractExpiry;
    }
}
