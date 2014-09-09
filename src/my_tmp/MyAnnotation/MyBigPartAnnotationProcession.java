package my_tmp.MyAnnotation;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by Admin on 07.09.14.
 */
public class MyBigPartAnnotationProcession {

    public static void main(String[] args) {
        Class myClass = MyBigPart.class;
        Field fields[] = myClass.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(MyForSave.class)) {
                MyBigPartWriter wr = new MyBigPartWriter(f, (f.getAnnotation(MyForSave.class).path()));
                try {
                    wr.objWriter();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
