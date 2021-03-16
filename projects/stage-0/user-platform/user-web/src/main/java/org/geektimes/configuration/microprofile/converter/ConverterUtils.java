package org.geektimes.configuration.microprofile.converter;

import org.eclipse.microprofile.config.spi.Converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @Author yang.hu
 * @Date 2021/3/16 10:33
 */
public class ConverterUtils {

    private static Map<Class, Converter> converterMap = new HashMap<>();

    static {
        ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);
        for (Converter converter : serviceLoader) {
            // 获取类型
            Type type = ((ParameterizedType) converter.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            converterMap.put((Class) type, converter);
        }
    }

    private ConverterUtils(){

    }

    public static <T> T convert(String value, Class<T> castType) throws IllegalArgumentException, NullPointerException {
        if (value == null || value.length() == 0) {
            throw  new NullPointerException("value can not be null or ''");
        }

        Converter<T> converter = converterMap.get(castType);
        if (converter == null) {
            throw new IllegalArgumentException("Can't convert value '" + value
                    + "' to type " + castType);
        }

        return converter.convert(value);
    }



}
