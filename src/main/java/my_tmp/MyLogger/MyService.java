package my_tmp.MyLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Admin on 21.09.14.
 */
public class MyService {

    private static final Logger logger = Logger.getLogger("my_tmp.MyLogger");

    public void baseInfo(){
        logger.log(Level.INFO, "use 1 gets info");
        System.out.println("Show some");
    }

    public void delete(int id){
        logger.log(Level.INFO, "use 1 gets info");
    }
}
