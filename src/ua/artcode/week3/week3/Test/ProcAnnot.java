package ua.artcode.week3.week3.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by 1 on 07.09.14.
 */
public class ProcAnnot {
    public static Class<? extends Annotation> forSave;

    public static void main(String[] args) throws NoSuchFieldException {
        Class cl = Container.class;
        cl.isAnnotation();
        Field field = cl.getDeclaredField("desc");
        System.out.println(field.isAnnotationPresent(ForSave.class));
    }

}
