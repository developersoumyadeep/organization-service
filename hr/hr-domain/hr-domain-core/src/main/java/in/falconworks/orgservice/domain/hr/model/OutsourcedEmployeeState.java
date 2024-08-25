package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.UserId;
import in.falconworks.orgservice.domain.establishment.model.Position;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class OutsourcedEmployeeState {
    private final UserId userId;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Address address;
    private final String mobile;
    private final String email;
    private final Position position;
    private final UserId vendorId;

    private OutsourcedEmployeeState(Builder builder) {
        userId = builder.userId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        dateOfBirth = builder.dateOfBirth;
        address = builder.address;
        mobile = builder.mobile;
        email = builder.email;
        position = builder.position;
        vendorId = builder.vendorId;
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
        private Position position;
        private UserId vendorId;

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

        public Builder position(Position val) {
            position = val;
            return this;
        }

        public Builder vendorId(UserId val) {
            vendorId = val;
            return this;
        }

        public OutsourcedEmployeeState build() {
            return new OutsourcedEmployeeState(this);
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

    public Position getPosition() {
        return position;
    }

    public UserId getVendorId() {
        return vendorId;
    }
}
