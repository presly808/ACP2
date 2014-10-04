package ua.artcode.week3.day2;

import java.lang.reflect.Field;

public class ProcessAnnotation {

    public static void main(String[] args) throws NoSuchFieldException {

        Class cl = Container.class;
        Field field = cl.getDeclaredField("description");
        ForSave annotation = field.getAnnotation(ForSave.class);
        System.out.println(field.isAnnotationPresent(ForSave.class));
        System.out.println(annotation.path());

    }

}
