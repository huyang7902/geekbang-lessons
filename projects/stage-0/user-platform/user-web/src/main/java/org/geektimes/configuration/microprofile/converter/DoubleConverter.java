package org.geektimes.configuration.microprofile.converter;

/**
 * @Author yang.hu
 * @Date 2021/3/15 18:19
 */
public class DoubleConverter extends AbstractConverter<Double> {



    @Override
    public Double convert(String value) throws IllegalArgumentException, NullPointerException {

        return Double.parseDouble(value);

    }
}
