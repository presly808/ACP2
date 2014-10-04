package ua.artcode.controller;

import ua.artcode.dao.DBDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by bm13 on 03.10.2014.
 */
public class ConfigurationImpl {
    private static String separator = System.getProperty("file.separator");

    public static Properties initProperties() throws IOException {
        String configFilePath = "jmail\\src\\test\\java\\ua\\artcode\\config\\env.properties";

        String path = configFilePath.replace("\\",separator);

        Properties settings = new Properties();
        settings.load(new FileInputStream(path));

        for ( String i : settings.stringPropertyNames()) {
            System.out.println(i + "=" + settings.getProperty(i));
        }

        return settings;
    }



    public static void applyProperties(Properties settings) throws SQLException, ClassNotFoundException {
        if (Boolean.valueOf(settings.getProperty("DBneeded"))) {
            DBDao.initDB(settings.getProperty("DBServerHost"), settings.getProperty("DBServerPort"), settings.getProperty("DBSchema"), settings.getProperty("DBuser"), settings.getProperty("DBpassword"));
        }
    }
}
