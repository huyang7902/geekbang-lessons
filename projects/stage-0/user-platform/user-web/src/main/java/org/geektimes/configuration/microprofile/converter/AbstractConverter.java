package org.geektimes.configuration.microprofile.converter;

import org.apache.commons.beanutils.ConversionException;
import org.eclipse.microprofile.config.spi.Converter;

/**
 * @Author yang.hu
 * @Date 2021/3/16 9:46
 */
public abstract class AbstractConverter<T>  implements Converter<T> {


    protected ConversionException conversionException(final Class<?> type, final Object value) {
        return new ConversionException("Can't convert value '" + value
                + "' to type " + type);
    }

}
