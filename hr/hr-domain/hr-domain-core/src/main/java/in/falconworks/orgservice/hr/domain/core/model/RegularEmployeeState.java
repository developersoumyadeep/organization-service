package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.UserId;

import java.time.LocalDate;

public class RegularEmployeeState {

    private final UserId userId;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final LocalDate dateOfJoiningAtService;
    private final Address address;
    private final String mobile;
    private final String email;
    private final Designation designation;
    private final Position position;
    private final boolean isRetired;
    private final LocalDate dateOfRetirement;

    private RegularEmployeeState(Builder builder) {
        userId = builder.userId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        dateOfBirth = builder.dateOfBirth;
        dateOfJoiningAtService = builder.dateOfJoiningAtService;
        address = builder.address;
        mobile = builder.mobile;
        email = builder.email;
        designation = builder.designation;
        position = builder.position;
        isRetired = builder.isRetired;
        dateOfRetirement = builder.dateOfRetirement;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
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

        public Builder() {
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

        public Builder dateOfJoiningAtService(LocalDate dateOfJoiningAtService) {
            this.dateOfJoiningAtService = dateOfJoiningAtService;
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

        public Builder designation(Designation val) {
            designation = val;
            return this;
        }

        public Builder position(Position val) {
            position = val;
            return this;
        }

        public Builder isRetired(boolean val) {
            isRetired = val;
            return this;
        }

        public Builder dateOfRetirement(LocalDate val) {
            dateOfRetirement = val;
            return this;
        }

        public RegularEmployeeState build() {
            return new RegularEmployeeState(this);
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

    public Designation getDesignation() {
        return designation;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isRetired() {
        return isRetired;
    }

    public LocalDate getDateOfRetirement() {
        return dateOfRetirement;
    }

    public LocalDate getDateOfJoiningAtService() {
        return dateOfJoiningAtService;
    }
}
