package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.hr.exception.EmployeeValidationException;

import java.time.LocalDate;
import java.util.logging.Logger;

record RetirementDetail(boolean isRetired, LocalDate dateOfRetirement) {

    private final static Logger logger = Logger.getLogger(RetirementDetail.class.getName());
    void validate() {
        logger.info("Validating retirement data");
        if (isRetired && dateOfRetirement == null) {
            throw new EmployeeValidationException("Retired employee must have valid retirement date");
        }
        logger.info("Retirement data validated");
    }
}
