package ua.artcode.week3.day2.saveToFile;

import ua.artcode.week3.day2.ForSave;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class SaveData {

    public static void refSave(Object o){
        PrintWriter pw = null;
        try {
            Class cl = o.getClass();
            Field[] fields = cl.getDeclaredFields();

            for (Field field : fields){
                field.setAccessible(true);

                if (field.isAnnotationPresent(ForSave.class)){
                    ForSave annotation = field.getAnnotation(ForSave.class);
                    pw = new PrintWriter(new FileWriter(annotation.path(), true));
                    pw.println(field.getName() + " " + field.get(o));
                    pw.flush();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }


}
