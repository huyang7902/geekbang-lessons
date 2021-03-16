package org.geektimes.configuration.microprofile.converter;

/**
 * @Author yang.hu
 * @Date 2021/3/15 18:19
 */
public class ShortConverter extends AbstractConverter<Short> {



    @Override
    public Short convert(String value) throws IllegalArgumentException, NullPointerException {

        return Short.parseShort(value);

    }
}
