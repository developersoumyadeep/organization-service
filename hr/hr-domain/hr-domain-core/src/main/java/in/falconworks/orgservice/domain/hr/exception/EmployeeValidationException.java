package in.falconworks.orgservice.domain.hr.exception;

import in.falconworks.orgservice.domain.common.exception.DomainException;

public class EmployeeValidationException extends DomainException {
    public EmployeeValidationException(String message) {
        super(message);
    }

    public EmployeeValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
