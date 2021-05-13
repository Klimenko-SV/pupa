package ru.pupa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfProperties {

//    protected static FileInputStream fileInputStream;
    private static Properties PROPERTIES;
     static  {
        try {
            /* ТАК НЕ РАБОТАЕТ
            InputStream inputStream = ConfProperties.class
                    .getResourceAsStream("src/test/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(inputStream);
             */
            //указание пути до файла с настройками
            PROPERTIES = new Properties();
            PROPERTIES.load(new FileInputStream("src/test/resources/conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод для возврата строки со значением из файла с настройками
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
