package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.hr.exception.EmployeeValidationException;
import java.util.logging.Logger;

record PersonName(String firstName, String lastName) {

    private static final Logger logger = Logger.getLogger(PersonName.class.getName());

    void validate() {
        logger.info("Validating name");
        if (firstName == null || firstName.isBlank()) {
            throw new EmployeeValidationException("Employee first name can not be blank or null");
        }
    }

    String getFullName() {
        return firstName +" "+lastName;
    }

}
