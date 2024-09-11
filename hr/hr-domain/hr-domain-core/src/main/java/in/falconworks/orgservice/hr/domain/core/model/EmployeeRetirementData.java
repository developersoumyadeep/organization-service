package in.falconworks.orgservice.hr.domain.core.model;

import in.falconworks.orgservice.domain.common.model.UserId;

import java.time.LocalDate;

public class EmployeeRetirementData {
    private final UserId userId;
    private final String firstName;
    private final String lastName;
    private final Designation designationBeforeRetirement;
    private final LocalDate dateOfRetirement;
    private final int yearOfService;

    private EmployeeRetirementData(Builder builder) {
        userId = builder.userId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        dateOfRetirement = builder.dateOfRetirement;
        yearOfService = builder.yearOfService;
        designationBeforeRetirement = builder.designationBeforeRetirement;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserId userId;
        private String firstName;
        private String lastName;
        private LocalDate dateOfRetirement;
        private int yearOfService;
        private Designation designationBeforeRetirement;

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

        public Builder dateOfRetirement(LocalDate val) {
            dateOfRetirement = val;
            return this;
        }

        public Builder yearOfService(int val) {
            yearOfService = val;
            return this;
        }

        public Builder designationBeforeRetirement(Designation designationBeforeRetirement) {
            this.designationBeforeRetirement = designationBeforeRetirement;
            return this;
        }

        public EmployeeRetirementData build() {
            return new EmployeeRetirementData(this);
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

    public LocalDate getDateOfRetirement() {
        return dateOfRetirement;
    }

    public int getYearOfService() {
        return yearOfService;
    }

    public Designation getDesignationBeforeRetirement() {
        return designationBeforeRetirement;
    }
}
