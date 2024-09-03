package in.falconworks.orgservice.domain.hr.exception;

import in.falconworks.orgservice.domain.common.exception.DomainException;

public class PositionValidationException extends DomainException {
    public PositionValidationException(String message) {
        super(message);
    }

    public PositionValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
