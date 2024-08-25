package in.falconworks.orgservice.domain.common.model;


import in.falconworks.orgservice.domain.common.exception.AddressValidationException;

public final class Address {
    private final String addressLine1;
    private final String addressLine2;
    private final String district;
    private final String pinCode;
    private final String state;
    private final String country;

    public void validate() {
        if (addressLine1 == null || addressLine1.isBlank()) {
            throw new AddressValidationException("Address line 1 can not be empty!");
        }
        if (pinCode == null || pinCode.isBlank()) {
            throw new AddressValidationException("Address pin code can not be empty!");
        }
        if (district == null || district.isBlank()) {
            throw new AddressValidationException("Address must contain a valid district");
        }
        if (state == null || state.isBlank()) {
            throw new AddressValidationException("Address state can not be empty!");
        }
        if (country == null || country.isBlank()) {
            throw new AddressValidationException("Address state can not be empty!");
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Address(Builder builder) {
        addressLine1 = builder.addressLine1;
        addressLine2 = builder.addressLine2;
        pinCode = builder.pinCode;
        state = builder.state;
        district = builder.district;
        country = builder.country;
    }

    public static final class Builder {
        private String addressLine1;
        private String addressLine2;
        private String pinCode;
        private String state;
        private String country;
        private String district;

        private Builder() {
        }

        public Builder addressLine1(String val) {
            addressLine1 = val;
            return this;
        }

        public Builder addressLine2(String val) {
            addressLine2 = val;
            return this;
        }

        public Builder pinCode(String val) {
            pinCode = val;
            return this;
        }

        public Builder state(String val) {
            state = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
            return this;
        }

        public Builder district(String val) {
            district = val;
            return this;
        }

         public Address build() {
            return new Address(this);
        }
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public String toString() {
        return
                 addressLine1 + "\n" +
                 addressLine2 + "\n" +
                 "Pin code: "+pinCode + "\n" +
                 "State: "+state + "\n" +
                 "Country: "+country + "\n";
    }
}
