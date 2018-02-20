package br.com.commons.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

    public final static Properties PROPS;

    static {
        PROPS = new Properties();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            try (InputStream resourceStream = classloader.getResourceAsStream("config.properties")) {
                PROPS.load(resourceStream);
            }
        } catch (IOException e) {

        }
    }

}
