package in.falconworks.orgservice.hr.domain.core.exception;

import in.falconworks.orgservice.domain.common.exception.DomainException;

public class ContactDetailsValidationException extends DomainException {
    public ContactDetailsValidationException(String message) {
        super(message);
    }

    public ContactDetailsValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}