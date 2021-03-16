package org.geektimes.configuration.microprofile.converter;

/**
 * @Author yang.hu
 * @Date 2021/3/15 18:19
 */
public class IntegerConverter extends AbstractConverter<Integer> {



    @Override
    public Integer convert(String value) throws IllegalArgumentException, NullPointerException {

        return Integer.parseInt(value);

    }
}
