package org.geektimes.configuration.demo;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

/**
 * @Author yang.hu
 * @Date 2021/3/16 11:39
 */
public class JavaConfigDemo {

    public static void main(String[] args) {
        Config config = ConfigProvider.getConfig();
        String value = config.getValue("application.name", String.class);
        System.out.println(value);
    }
}
