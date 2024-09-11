package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.UserId;

@SuppressWarnings("FieldCanBeLocal")
public class VendorState {
    private final UserId userId;
    private final String vendorName;
    private final String proprietorFirstName;
    private final String proprietorLastName;
    private final String mobile;
    private final String email;
    private final Address address;
    private final VendorId vendorId;

    public VendorState(Builder builder) {
        userId = builder.userId;
        vendorName = builder.vendorName;
        proprietorFirstName = builder.proprietorFirstName;
        proprietorLastName = builder.proprietorLastName;
        mobile = builder.mobile;
        email = builder.email;
        address = builder.address;
        vendorId = builder.vendorId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UserId userId;
        private String vendorName;
        private String proprietorFirstName;
        private String proprietorLastName;
        private String mobile;
        private String email;
        private Address address;
        private VendorId vendorId;

        public Builder userId(UserId val) {
            this.userId = val;
            return this;
        }

        public Builder vendorName(String vendorName) {
            this.vendorName = vendorName;
            return this;
        }

        public Builder proprietorFirstName(String proprietorFirstName) {
            this.proprietorFirstName = proprietorFirstName;
            return this;
        }

        public Builder proprietorLastName(String proprietorLastName) {
            this.proprietorLastName = proprietorLastName;
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

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder vendorId(VendorId vendorId) {
            this.vendorId = vendorId;
            return this;
        }

        public VendorState build() {
            return new VendorState(this);
        }
    }

    public UserId getUserId() {
        return userId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getProprietorFirstName() {
        return proprietorFirstName;
    }

    public String getProprietorLastName() {
        return proprietorLastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public VendorId getVendorId() {
        return vendorId;
    }
}
