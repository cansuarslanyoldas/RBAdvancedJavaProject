package com.finalproject.enums;

public class Enums {
    public enum ErrorMessages{
        INVALID_DATE_FORMAT_EXCEPTION("Invalid Date Format Exception! Use the valid format: "),
        CONVERSION_LIST_EXCEPTION("Conversion list is empty or invalid transaction id!"),
        RATE_IS_NULL_EXCEPTION("Rate is unavailable. Please verify your source or target input parameters.."),
        CONVERT_RESPONSE_IS_NULL_EXCEPTION("The conversion from %s to %s is not available in the conversion table."),
        SOURCE_AND_TARGET_MUST_BE_DIFFERENT("Source and target must be different from each other for the conversion.");
        private String value;

        ErrorMessages(String value) {
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public enum ValidParameters{
        VALID_DATE_FORMAT("yyyy-MM-dd HH:mm:ss.SSSSSS");
        private String value;

        ValidParameters(String value) {
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public enum TestParameters{
        TEST_TRANSACTION_DATE("aa123123aa");
        private String value;

        TestParameters(String value) {
            this.value=value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
