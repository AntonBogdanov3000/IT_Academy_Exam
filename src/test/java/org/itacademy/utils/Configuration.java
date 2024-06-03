package org.itacademy.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static Properties properties;

    public static Properties getProperties(){
        if(properties == null){
            try {
                properties = new Properties();
                properties.load(new FileInputStream("project.properties"));
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        return properties;
    }

    public static String getScreenShotFolder(){
        return getProperties().getProperty("screenShots");
    }
}
