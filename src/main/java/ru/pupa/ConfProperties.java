package ru.pupa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfProperties {

    protected static FileInputStream fileInputStream;
    private static Properties PROPERTIES;
     static  {
        try {
            //указание пути до файла с настройками
            InputStream inputStream = ConfProperties.class.getResourceAsStream("/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(inputStream);
//          PROPERTIES.load(new FileInputStream("src/test/resources/conf.properties")); // -ЧТЕНИЕ КАК ФАЙЛ А НЕ РЕСУРС
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод для возврата строки со значением из файла с настройками
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
