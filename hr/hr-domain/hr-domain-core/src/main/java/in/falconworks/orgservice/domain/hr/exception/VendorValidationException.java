package in.falconworks.orgservice.domain.hr.exception;

import in.falconworks.orgservice.domain.common.exception.DomainException;

public class VendorValidationException extends DomainException {
    public VendorValidationException(String message) {
        super(message);
    }

    public VendorValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
