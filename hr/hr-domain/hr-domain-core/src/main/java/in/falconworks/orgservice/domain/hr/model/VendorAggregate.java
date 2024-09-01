package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.AggregateRoot;
import in.falconworks.orgservice.domain.common.model.UserId;
import in.falconworks.orgservice.domain.hr.event.VendorCreatedEvent;
import in.falconworks.orgservice.domain.hr.exception.VendorValidationException;

import java.util.logging.Logger;

public class VendorAggregate implements AggregateRoot {
    private final UserId userId;
    private final String vendorName;
    private final PersonName proprietorName;
    private final ContactDetails contactDetails;
    private final VendorId vendorId;
    private final Logger logger = Logger.getLogger(getClass().getName());


    public VendorCreatedEvent validateAndInitialize() {
        validate();
        return new VendorCreatedEvent(getState());
    }

    public VendorState getState() {
        return VendorState.builder()
                .userId(userId)
                .vendorId(vendorId)
                .vendorName(vendorName)
                .proprietorFirstName(proprietorName.firstName())
                .proprietorLastName(proprietorName.lastName())
                .mobile(contactDetails.mobile())
                .email(contactDetails.email())
                .address(contactDetails.address())
                .build();
    }


    private VendorAggregate(Builder builder) {
        userId = builder.userId;
        vendorName = builder.vendorName;
        proprietorName = new PersonName(builder.proprietorFirstName, builder.proprietorLastName);
        contactDetails = new ContactDetails(builder.mobile, builder.email, builder.address);
        vendorId = builder.vendorId;
    }

    private void validate() {
        if (userId == null) {
            throw new VendorValidationException("Vendor must have a valid user id");
        }
        logger.info("Validating vendor with user id "+userId.id());
        if (vendorName == null || vendorName.isBlank()) {
            throw new VendorValidationException("Vendor must have a valid name");
        }
        proprietorName.validate();
        contactDetails.validate();
        if (vendorId == null) {
            throw new VendorValidationException("Vendor must have a valid vendor id");
        }
        logger.info("Validated vendor with user id "+userId.id());
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

        public VendorAggregate build() {
            return new VendorAggregate(this);
        }
    }
}

