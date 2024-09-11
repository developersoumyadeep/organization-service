package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.PositionId;
import in.falconworks.orgservice.domain.common.model.UserId;

import java.time.LocalDate;

public class PositionChangeData {
    private UserId userId;
    private String firstName;
    private String lastName;
    private PositionId lastPositionId;
    private PositionId newPositionId;
    private LocalDate dateOfPositionChange;

    private PositionChangeData(Builder builder) {
        userId = builder.userId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        lastPositionId = builder.lastPositionId;
        newPositionId = builder.newPositionId;
        dateOfPositionChange = builder.dateOfPositionChange;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        public LocalDate dateOfPositionChange;
        private UserId userId;
        private String firstName;
        private String lastName;
        private PositionId lastPositionId;
        private PositionId newPositionId;

        private Builder() {
        }

       public Builder dateOfPositionChange(LocalDate aDate) {
            this.dateOfPositionChange = aDate;
            return this;
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

        public Builder lastPositionId(PositionId val) {
            lastPositionId = val;
            return this;
        }

        public Builder newPositionId(PositionId val) {
            newPositionId = val;
            return this;
        }

        public PositionChangeData build() {
            return new PositionChangeData(this);
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

    public PositionId getLastPositionId() {
        return lastPositionId;
    }

    public PositionId getNewPositionId() {
        return newPositionId;
    }

    public LocalDate getDateOfPositionChange() {
        return dateOfPositionChange;
    }
}
