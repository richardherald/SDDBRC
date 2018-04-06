package br.com.sddbrc.commons.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

    public final static Properties DB;

    static {
        DB = new Properties();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            try (InputStream resourceStream = classloader.getResourceAsStream("db.properties")) {
                DB.load(resourceStream);
            }
            
            
        } catch (IOException e) {

        }
    }

}
