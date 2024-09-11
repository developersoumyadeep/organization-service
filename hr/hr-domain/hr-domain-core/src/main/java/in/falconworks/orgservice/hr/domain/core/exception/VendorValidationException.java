package in.falconworks.orgservice.hr.domain.core.exception;

import in.falconworks.orgservice.domain.common.exception.DomainException;

public class VendorValidationException extends DomainException {
    public VendorValidationException(String message) {
        super(message);
    }

    public VendorValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
