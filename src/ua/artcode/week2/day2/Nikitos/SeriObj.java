package ua.artcode.week2.day2.Nikitos;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by 1 on 04.09.14.
 */
public class SeriObj {


    public static boolean writeObjInFile(String pathToFile,Serializable object){
        try {
            FileOutputStream str = new FileOutputStream(pathToFile);
            ObjectOutputStream out = new ObjectOutputStream(str);
            out.writeObject(object);
            if(str != null) {
                str.close();
            }if(out != null){
                out.close();
            }
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
        }
    public static boolean writeObjCollection(String pathToFile,Collection<Serializable> objects){
        try {
            FileOutputStream str = new FileOutputStream(pathToFile);
            ObjectOutputStream out = new ObjectOutputStream(str);
            Iterator iterator = objects.iterator();
            while (iterator.hasNext()){
                out.writeObject(iterator.next());
            }
            if(str != null) {
                str.close();
            }if(out != null){
                out.close();
            }

        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
       return true;
    }
    public static boolean wrriteReflectionObject(String pashToFile, Serializable object){
        Class c = object.getClass();
        Field [] fields = c.getDeclaredFields();
        Method [] methods = c.getDeclaredMethods();

        return true;
    }
    private String methodName(String name){
        String s = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
        return s;
    }
}
