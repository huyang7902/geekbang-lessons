package org.geektimes.configuration.microprofile.converter;

/**
 * @Author yang.hu
 * @Date 2021/3/15 18:19
 */
public class ByteConverter extends AbstractConverter<Byte> {


    @Override
    public Byte convert(String value) throws IllegalArgumentException, NullPointerException {

        return Byte.parseByte(value);

    }
}
