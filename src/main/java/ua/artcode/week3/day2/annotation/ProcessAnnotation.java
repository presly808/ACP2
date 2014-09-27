package ua.artcode.week3.day2.annotation;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by admin on 07.09.2014.
 */
public class ProcessAnnotation {

    public static void processObject(Object o) throws IllegalAccessException, IOException {
        Class cl = o.getClass();
        ForSave root = (ForSave) cl.getAnnotation(ForSave.class);
        String rootPath = root.path();
        FileUtils.preparePlace(rootPath);

        for(Field field : cl.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(ForSave.class)){
                ForSave pathAnotaion = field.getAnnotation(ForSave.class);
                String filepath = pathAnotaion.path();
                FileUtils.save(field.get(o).toString(), filepath);
            }

        }
    }



}
