package org.geektimes.configuration.microprofile.converter;

/**
 * @Author yang.hu
 * @Date 2021/3/15 18:19
 */
public class LongConverter extends AbstractConverter<Long> {



    @Override
    public Long convert(String value) throws IllegalArgumentException, NullPointerException {

        return Long.parseLong(value);

    }
}
