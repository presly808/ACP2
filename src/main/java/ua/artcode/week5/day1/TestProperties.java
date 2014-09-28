package ua.artcode.week5.day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by admin on 27.09.2014.
 */
public class TestProperties {

    public static void main(String[] args) throws IOException {
        MySettings mySettings = SettingsPropertiesMapper.convert("src/main/java/ua/artcode/week5/day1/settings.properties");

    }

}
