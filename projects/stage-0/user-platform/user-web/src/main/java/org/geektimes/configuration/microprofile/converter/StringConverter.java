package org.geektimes.configuration.microprofile.converter;

/**
 * @Author yang.hu
 * @Date 2021/3/15 18:19
 */
public class StringConverter extends AbstractConverter<String> {



    @Override
    public String convert(String value) throws IllegalArgumentException, NullPointerException {

        return value;

    }
}
