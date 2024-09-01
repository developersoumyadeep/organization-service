package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.common.model.UserId;

import java.time.LocalDate;

public class ContractExpiryData {
    private final UserId userId;
    private final String firstName;
    private final String lastName;
    private final Designation designation;
    private final LocalDate contractExpiryDate;

    private ContractExpiryData(Builder builder) {
        userId = builder.userId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        designation = builder.designation;
        contractExpiryDate = builder.contractExpiryDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserId userId;
        private String firstName;
        private String lastName;
        private Designation designation;
        private LocalDate contractExpiryDate;

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

        public Builder designation(Designation val) {
            designation = val;
            return this;
        }

        public Builder contractExpiryDate(LocalDate val) {
            contractExpiryDate = val;
            return this;
        }

        public ContractExpiryData build() {
            return new ContractExpiryData(this);
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

    public Designation getDesignation() {
        return designation;
    }

    public LocalDate getContractExpiryDate() {
        return contractExpiryDate;
    }
}
