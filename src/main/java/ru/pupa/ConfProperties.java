package ru.pupa;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfProperties {

     private static Properties PROPERTIES;
     static {
        try (InputStream inputStream = ConfProperties.class.getResourceAsStream("/conf.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод для возврата строки со значением из файла с настройками
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
