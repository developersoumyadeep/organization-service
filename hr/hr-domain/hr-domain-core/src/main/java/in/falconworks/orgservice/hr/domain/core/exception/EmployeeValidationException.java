package in.falconworks.orgservice.hr.domain.core.exception;

import in.falconworks.orgservice.domain.common.exception.DomainException;

public class EmployeeValidationException extends DomainException {
    public EmployeeValidationException(String message) {
        super(message);
    }

    public EmployeeValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
