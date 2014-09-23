package ua.artcode.week4.day1.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by admin on 21.09.2014.
 */
public class Service {

    private final static Logger logger = Logger.getLogger("ua.artcode.week1");


    public void basicInfo(){
        logger.log(Level.INFO, "user 1 gets info");
    }

    public void delete(int id){
        logger.log(Level.INFO, "user 1 delete");
    }


}
