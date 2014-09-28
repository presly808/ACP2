package ua.artcode.week5.day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by admin on 27.09.2014.
 */
public class SettingsPropertiesMapper {

    public static MySettings convert(String path){
        Properties pr = new Properties();

        try {
            pr.load(new FileInputStream(path));
            return new MySettings(pr.getProperty("server.ip"),
                                    Integer.parseInt(pr.getProperty("server.port")),
                                    Integer.parseInt(pr.getProperty("server.users.limit")));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
