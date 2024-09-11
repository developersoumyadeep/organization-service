package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.UserId;

import java.time.LocalDate;

public class DesignationChangeData {
    private final UserId userId;
    private final String firstName;
    private final String lastName;
    private final Designation lastDesignation;
    private final Designation newDesignation;
    private final LocalDate dateOfDesignationChange;

    private DesignationChangeData(Builder builder) {
        userId = builder.userId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        lastDesignation = builder.lastDesignation;
        newDesignation = builder.newDesignation;
        dateOfDesignationChange = builder.dateOfDesignationChange;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserId userId;
        private String firstName;
        private String lastName;
        private Designation lastDesignation;
        private Designation newDesignation;
        private LocalDate dateOfDesignationChange;

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

        public Builder lastDesignation(Designation val) {
            lastDesignation = val;
            return this;
        }

        public Builder newDesignation(Designation val) {
            newDesignation = val;
            return this;
        }

        public Builder dateOfDesignationChange(LocalDate val) {
            dateOfDesignationChange = val;
            return this;
        }

        public DesignationChangeData build() {
            return new DesignationChangeData(this);
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

    public Designation getLastDesignation() {
        return lastDesignation;
    }

    public Designation getNewDesignation() {
        return newDesignation;
    }

    public LocalDate getDateOfDesignationChange() {
        return dateOfDesignationChange;
    }
}
