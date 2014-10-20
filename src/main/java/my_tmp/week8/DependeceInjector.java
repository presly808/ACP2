package my_tmp.week8;

import java.lang.reflect.Field;

public class DependeceInjector{
    public static void main(String[] args) throws NoSuchFieldException {
        Class cl = TextReader.class;
        Field field = cl.getDeclaredField("str");
        ForInject annotation = field.getAnnotation(ForInject.class);

    }

}