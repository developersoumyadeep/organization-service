package in.falconworks.orgservice.domain.hr.exception;

import in.falconworks.orgservice.domain.common.exception.DomainException;

public class UserValidationException extends DomainException {

    public UserValidationException(String message) {
        super(message);
    }

    public UserValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
