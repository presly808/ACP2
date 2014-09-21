package ua.artcode.week4.day1.logging;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

/**
 * Created by admin on 20.09.2014.
 */
public class TestLogging {

    public static void main(String[] args) throws IOException {
        final Logger logger = Logger.getLogger("ua.artcode");


        System.out.println(logger.getLevel());
        //TODO : Formatter
        Handler fileHandler = new FileHandler("myapp-log.%u.%g.txt");
        fileHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel().getName() + " "+new Date().toString()
                        + " " + record.getMessage()+"\n";
            }
        });
        fileHandler.setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                return record.getLevel().intValue() >= 900;
            }
        });
        //logger.addHandler(console);
        logger.addHandler(fileHandler);
        logger.log(Level.SEVERE, "Info message");


        Logger child = Logger.getLogger("ua.artcode.week4");
        child.log(Level.INFO, "child log");

    }

}
