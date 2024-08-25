package in.falconworks.orgservice.domain.hr.exception;

import in.falconworks.orgservice.domain.common.exception.DomainException;

public class DesignationValidationException extends DomainException {

    public DesignationValidationException(String message) {
        super(message);
    }

    public DesignationValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
