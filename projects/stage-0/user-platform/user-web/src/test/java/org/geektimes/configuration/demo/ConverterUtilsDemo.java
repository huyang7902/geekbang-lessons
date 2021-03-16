package org.geektimes.configuration.demo;

import org.geektimes.configuration.microprofile.converter.ConverterUtils;

/**
 *
 * @see ConverterUtils
 *
 * @Author yang.hu
 * @Date 2021/3/16 10:55
 */
public class ConverterUtilsDemo {

    public static void main(String[] args) {
        Boolean booleanConvert = ConverterUtils.convert("1", Boolean.class);
        System.out.println(booleanConvert);

        Integer integer = ConverterUtils.convert("123", Integer.class);
        System.out.println(integer);

        Short aShort = ConverterUtils.convert("123", Short.class);
        System.out.println(aShort);

        Byte aByte = ConverterUtils.convert("b", Byte.class);
        System.out.println(aByte);
    }
}
