package in.falconworks.orgservice.domain.hr.model;

import in.falconworks.orgservice.domain.hr.exception.ContactDetailsValidationException;
import in.falconworks.orgservice.domain.common.model.Address;

import java.util.logging.Logger;

record ContactDetails (String mobile, String email, Address address){

    private static final Logger logger = Logger.getLogger(ContactDetails.class.getName());
    void validate() {
        logger.info("Validating contact details");
        validateMobile();
        validateAddress();
        validateEmail();
        logger.info("Contact details validated");
    }

    private void validateEmail() {
        logger.info("Validating email");
        if (email == null || email.isBlank()) {
            throw new ContactDetailsValidationException("Email address must not be empty or null");
        }
        if (!isValidEmailAddress(email)) {
            throw new ContactDetailsValidationException("Invalid email address");
        }
        logger.info("Email validated");
    }

    private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\" +
                ".[0-9]{1,3}\\." +
                "[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    private void validateAddress() {
        logger.info("Validating address");
        if (address == null) {
            throw new ContactDetailsValidationException("Address can not be null");
        }
        address.validate();
        logger.info("Address validated");
    }

    private void validateMobile() {
        logger.info("Validating mobile");
        if (mobile == null || mobile.length()<10) {
            throw new ContactDetailsValidationException("Invalid mobile number!");
        }
        logger.info("Mobile number validated");
    }
}
