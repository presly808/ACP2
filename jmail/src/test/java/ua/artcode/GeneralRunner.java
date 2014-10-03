package ua.artcode;

import ua.artcode.controller.ConfigurationController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by bm13 on 03.10.2014.
 */
public class GeneralRunner {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Properties settings = ConfigurationController.initProperties();
        ConfigurationController.applyProperties(settings);
    }

}
