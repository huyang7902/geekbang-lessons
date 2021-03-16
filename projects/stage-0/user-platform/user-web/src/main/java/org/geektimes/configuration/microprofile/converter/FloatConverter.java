package org.geektimes.configuration.microprofile.converter;

/**
 * @Author yang.hu
 * @Date 2021/3/15 18:19
 */
public class FloatConverter extends AbstractConverter<Float> {



    @Override
    public Float convert(String value) throws IllegalArgumentException, NullPointerException {

        return Float.parseFloat(value);

    }
}
