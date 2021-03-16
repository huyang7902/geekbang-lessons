package org.geektimes.configuration.microprofile.converter;

/**
 * @Author yang.hu
 * @Date 2021/3/15 18:19
 */
public class BooleanConverter extends AbstractConverter<Boolean> {


    /**
     * The set of strings that are known to map to Boolean.TRUE.
     */
    private String[] trueStrings = {"true", "yes", "y", "on", "1"};

    /**
     * The set of strings that are known to map to Boolean.FALSE.
     */
    private String[] falseStrings = {"false", "no", "n", "off", "0"};

    @Override
    public Boolean convert(String value) throws IllegalArgumentException, NullPointerException {
            final String stringValue = value.toString().toLowerCase();

            for (String trueString : trueStrings) {
                if (trueString.equals(stringValue)) {
                    return Boolean.class.cast(Boolean.TRUE);
                }
            }

            for (String falseString : falseStrings) {
                if (falseString.equals(stringValue)) {
                    return Boolean.class.cast(Boolean.FALSE);
                }
            }

        throw conversionException(Boolean.class, value);
    }
}
