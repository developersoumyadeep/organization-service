package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.UserId;

public class ContactDetailsChangeData {
    private final UserId userId;
    private final String firstName;
    private final String lastName;
    private final ContactDetails newContactDetails;

    private ContactDetailsChangeData(Builder builder) {
        userId = builder.userId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        newContactDetails = builder.newContactDetails;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private UserId userId;
        private String firstName;
        private String lastName;
        private ContactDetails newContactDetails;

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

        public Builder newContactDetails(ContactDetails val) {
            newContactDetails = val;
            return this;
        }

        public ContactDetailsChangeData build() {
            return new ContactDetailsChangeData(this);
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

    public ContactDetails getNewContactDetails() {
        return newContactDetails;
    }
}
