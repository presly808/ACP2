package ua.artcode.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by bm13 on 03.10.2014.
 */
public class ConfigurationController {
    private static String separator = System.getProperty("file.separator");

    public static Properties initProperties() throws IOException {
        String configFilePath = "\\jmail\\src\\test\\java\\ua\\artcode\\config\\env.properties";

        String path = configFilePath.replace("\\",separator);

        Properties settings = new Properties();
        settings.load(new FileInputStream(System.getProperty("user.dir") + path));
        
        for ( String i : settings.stringPropertyNames()) {
            System.out.println(i + "=" + settings.getProperty(i));
        }
        
        return settings;
    }



    public static void applyProperties(Properties settings) throws SQLException, ClassNotFoundException {
        if (Boolean.valueOf(settings.getProperty("DBneeded"))) {
            DBController.initDB(settings.getProperty("DBServerHost"),settings.getProperty("DBServerPort"),settings.getProperty("DBSchema"),settings.getProperty("DBuser"),settings.getProperty("DBpassword"));
        }
    }
}
