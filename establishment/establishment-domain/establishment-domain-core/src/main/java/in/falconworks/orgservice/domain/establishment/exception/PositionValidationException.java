package in.falconworks.orgservice.domain.establishment.exception;

import in.falconworks.orgservice.domain.common.exception.DomainException;

public class PositionValidationException extends DomainException {
    public PositionValidationException(String message) {
        super(message);
    }

    public PositionValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
