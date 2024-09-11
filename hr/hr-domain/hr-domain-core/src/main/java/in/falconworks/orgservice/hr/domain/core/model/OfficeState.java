package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.Address;
import in.falconworks.orgservice.domain.common.model.OfficeId;
import in.falconworks.orgservice.domain.common.model.PositionId;

import java.util.List;

public class OfficeState {
    private final OfficeId officeId;
    private final String officeIdentifier;
    private final Address officeAddress;
    private final List<PositionId> positionIds;
    private final List<OfficeId> childOfficeIds;
    private OfficeId parentOfficeId;

    private OfficeState(Builder builder) {
        this.officeId = builder.officeId;
        officeIdentifier = builder.officeIdentifier;
        officeAddress = builder.officeAddress;
        positionIds = builder.positionIds;
        childOfficeIds = builder.childOfficeIds;
        parentOfficeId = builder.parentOfficeId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private OfficeId officeId;
        private String officeIdentifier;
        private Address officeAddress;
        private List<PositionId> positionIds;
        private List<OfficeId> childOfficeIds;
        private OfficeId parentOfficeId;

        private Builder() {
        }

        public Builder officeId(OfficeId val) {
            officeId = val;
            return this;
        }

        public Builder officeIdentifier(String val) {
            officeIdentifier = val;
            return this;
        }

        public Builder officeAddress(Address val) {
            officeAddress = val;
            return this;
        }

        public Builder positionIds(List<PositionId> val) {
            positionIds = val;
            return this;
        }

        public Builder childOfficeIds(List<OfficeId> val) {
            childOfficeIds = val;
            return this;
        }

        public Builder parentOfficeId(OfficeId val) {
            parentOfficeId = val;
            return this;
        }

        public OfficeState build() {
            return new OfficeState(this);
        }
    }

    public OfficeId getOfficeId() {
        return officeId;
    }

    public String getOfficeIdentifier() {
        return officeIdentifier;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public List<PositionId> getPositionIds() {
        return positionIds;
    }

    public List<OfficeId> getChildOfficeIds() {
        return childOfficeIds;
    }

    public OfficeId getParentOfficeId() {
        return parentOfficeId;
    }
}
