package ua.artcode.week4.day1.logging;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class TestLogging {

    public static void main(String[] args) throws IOException {
        final Logger logger = Logger.getLogger("ua.artcode");
        System.out.println(logger.getLevel());
        //TODO : java.util.Formatter.class возможность описать шаблон вывода
        //Handler console = new ConsoleHandler();
        Handler file = new FileHandler("my-file-logger");
        file.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel().getName() + " " + new Date().toString() + " " + record.getMessage() + "\n";
            }
        });
        file.setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                return record.getLevel().intValue() >= 900;
            }
        });
        //logger.addHandler(console);
        logger.addHandler(file);

        //logger.log(Level.INFO, "Info message ");
        Logger child = Logger.getLogger("ua.artcode.week4");
        child.log(Level.INFO, "child log");

    }

}
