package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.OfficeId;
import in.falconworks.orgservice.domain.common.model.PositionId;

public class PositionData {
    private final PositionId positionId;
    private final OfficeId officeId;
    private final String positionIdentifier;
    private final String positionDescription;
    private final boolean isChairPosition;


    private PositionData(Builder builder) {
        positionId = builder.positionId;
        officeId = builder.officeId;
        positionIdentifier = builder.positionIdentifier;
        positionDescription = builder.positionDescription;
        isChairPosition = builder.isChairPosition;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PositionId positionId;
        private OfficeId officeId;
        private String positionIdentifier;
        private String positionDescription;
        private boolean isChairPosition;

        private Builder() {}

        public  Builder positionId(PositionId id) {
            this.positionId = id;
            return this;
        }

        public Builder officeId(OfficeId id) {
            this.officeId = id;
            return this;
        }

        public Builder positionIdentifier(String positionIdentifier) {
            this.positionIdentifier = positionIdentifier;
            return this;
        }

        public Builder positionDescription(String positionDescription) {
            this.positionDescription = positionDescription;
            return this;
        }

        public Builder isChairPosition(boolean isChairPosition) {
            this.isChairPosition = isChairPosition;
            return this;
        }

        public PositionData build() {
            return new PositionData(this);
        }
    }

    public PositionId getPositionId() {
        return positionId;
    }

    public OfficeId getOfficeId() {
        return officeId;
    }

    public String getPositionIdentifier() {
        return positionIdentifier;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public boolean isChairPosition() {
        return isChairPosition;
    }
}
