package my_tmp.MyAnnotation;

import java.lang.reflect.Field;

/**
 * Created by Admin on 07.09.14.
 */
public class MyProcessAnnotation {
    public static void main(String[] args) throws NoSuchFieldException {
        Class cl = MyContainer.class;
        Field field = cl.getDeclaredField("desc");
        MyForSave annotation = field.getAnnotation(MyForSave.class);
        System.out.println(field.isAnnotationPresent(MyForSave.class));
        System.out.println(annotation.name());
    }
}
