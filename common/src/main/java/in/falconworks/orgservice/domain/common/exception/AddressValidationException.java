package in.falconworks.orgservice.domain.common.exception;

public class AddressValidationException extends DomainException{
    public AddressValidationException(String message) {
        super(message);
    }

    public AddressValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
