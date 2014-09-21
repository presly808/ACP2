package my_tmp.MyLogger;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

/**
 * Created by Admin on 20.09.14.
 */
public class MyLogger {
    public static void main(String[] args) throws IOException {
        final Logger logger = Logger.getLogger("Name");
        System.out.println(logger.getLevel());
        logger.log(Level.INFO, "Info message");
        logger.log(Level.SEVERE, "SEVER warning");
       // Handler console = new ConsoleHandler();
        Handler fileHandler = new FileHandler("myapp-log.%u.%g.txt");
        fileHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel().getName() + " " + new Date().toString()
                        + " " + record.getMessage() + "\n";
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

        Logger child = Logger.getLogger("Name/MyLogger");
        child.log(Level.INFO, "child log");


    }
}
