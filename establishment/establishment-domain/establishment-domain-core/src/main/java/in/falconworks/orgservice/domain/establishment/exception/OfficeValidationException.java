package in.falconworks.orgservice.domain.establishment.exception;

import in.falconworks.orgservice.domain.common.exception.DomainException;

public class OfficeValidationException extends DomainException {

    public OfficeValidationException(String message) {
        super(message);
    }

    public OfficeValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
