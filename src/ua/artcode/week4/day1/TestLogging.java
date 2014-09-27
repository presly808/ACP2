package ua.artcode.week4.day1;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

/**
 * Created by 1 on 20.09.14.
 */
public class TestLogging {
    public static void main(String[] args) throws IOException {
       final  Logger logger = Logger.getLogger("ua.artcode");
        logger.setLevel(Level.CONFIG);
        System.out.println("Level");
        System.out.println(logger.getLevel());
        System.out.println("________");

        logger.addHandler(new ConsoleHandler());
        Handler handler = new FileHandler("asdfg.txt");


        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel().getName() + " " +  " "+ new Date().toString()+ "\n" + record.getMessage();
            }
        });
        handler.setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                return record.getLevel().intValue() >= 900;
            }
        });
        logger.addHandler(handler);
        logger.log(Level.INFO,"info msg");

        Logger child = Logger.getLogger("ua.artcode.week4");
        child.log(Level.INFO, "child log");


    }
}
