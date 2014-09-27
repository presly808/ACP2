package ua.artcode.week3.week3.HM.Chat;


import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

/**
 * Created by 1 on 23.09.14.
 */
public class Toto {
    static final Logger log = Logger.getLogger("com.chat")  ;
    public Toto()  {
        try {
            Handler handler = new FileHandler("chatLogging%u.txt");
            handler.setFilter(new Filter() {

                @Override
                public boolean isLoggable(LogRecord record) {
                    // TODO Auto-generated method stub
                    return record.getLevel().intValue() >= 500;
                }
            });
            handler.setFormatter(new Formatter() {

                @Override
                public String format(LogRecord record) {

                    return new Date().toString()+" "+record.getLoggerName()+ " Lvl:"+record.getLevel() +" \nRecord msg:"+record.getMessage()+"\n";
                }
            });
            log.addHandler(handler);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void gogo(){
        String str = "Console logging testdrive";
        System.out.println("--------");
    log.log(Level.INFO,str);
    }
}
