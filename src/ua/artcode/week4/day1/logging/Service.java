package ua.artcode.week4.day1.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Service {

    private final static Logger logger = Logger.getLogger("ua.artcode.week1");

    public void basicInfo(){
        logger.log(Level.INFO, "user 1 get info");
    }

    public void delete(int id){
        logger.log(Level.INFO, "User 1 delete");
    }
}
