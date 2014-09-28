package ua.artcode.week5.day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsPeopertiesMapper {

    public static MySettings convert(String path){

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path) /*TestProperties.class.getResourceAsStream("Settings.properties")*/);
            return new MySettings(properties.getProperty("server.ip"), Integer.parseInt(properties.getProperty("server.port")), Integer.parseInt(properties.getProperty("server.user.limit")));

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
