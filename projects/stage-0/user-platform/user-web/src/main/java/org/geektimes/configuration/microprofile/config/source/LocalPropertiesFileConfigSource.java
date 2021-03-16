package org.geektimes.configuration.microprofile.config.source;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *  本地配置文件
 * @Author  yang.hu
 * @Date 2021/3/16 11:07
 */

public class LocalPropertiesFileConfigSource implements ConfigSource {

    private static final String FILE_NAME = "microprofile-config.properties";

    private final Map<String, String> properties = new HashMap<>();

    public LocalPropertiesFileConfigSource() throws Exception{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("META-INF/" + FILE_NAME)) {
            Properties p = new Properties();
            p.load(inputStream);
            p.entrySet().forEach(entry -> {
                properties.put((String)entry.getKey(), (String) entry.getValue());
            });
        }
    }

    @Override
    public Set<String> getPropertyNames() {
        return properties.keySet();
    }

    @Override
    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public String getName() {
        return "Java file Properties";
    }
}
