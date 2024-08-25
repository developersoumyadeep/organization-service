package in.falconworks.orgservice.domain.establishment.model;

import in.falconworks.orgservice.domain.common.model.PositionId;
import in.falconworks.orgservice.domain.establishment.exception.PositionValidationException;

import java.util.logging.Logger;

public class Position {
    private final PositionId positionId;
    private final String positionIdentifier;
    private final String positionDescription;
    private boolean isChairPosition;
    private final Logger logger = Logger.getLogger(getClass().getName());

    private Position(Builder builder) {
        positionId = builder.positionId;
        positionIdentifier = builder.positionIdentifier;
        positionDescription = builder.positionDescription;
        validate();
    }

    private void validate() {
        logger.info("Validating new position");
        if (positionId == null) {
            throw new PositionValidationException("Position id can not be null");
        }
        if (positionIdentifier.isBlank() || positionDescription.isBlank()) {
            throw new PositionValidationException("Position must have valid description and identifier");
        }
        logger.info("Position "+positionId+" ("+positionIdentifier+") validated");
    }

    public void setAsChairPosition(boolean setAsChair) {
        isChairPosition = setAsChair;
    }

    public boolean isChairPosition() {
        return isChairPosition;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private PositionId positionId;
        private String positionIdentifier;
        private String positionDescription;

        private Builder() {
        }

        public Builder positionId(PositionId val) {
            positionId = val;
            return this;
        }

        public Builder positionIdentifier(String val) {
            positionIdentifier = val;
            return this;
        }

        public Builder positionDescription(String val) {
            positionDescription = val;
            return this;
        }

        public Position build() {
            return new Position(this);
        }
    }
}
