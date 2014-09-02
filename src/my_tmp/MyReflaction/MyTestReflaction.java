package my_tmp.MyReflaction;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Admin on 31.08.14.
 */
public class MyTestReflaction {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        MyEmployee employee = new MyEmployee("Jack", 2000, 30);

        System.out.println("call method showFullInfo");
        showFullInfo(employee);
        System.out.println("call method getMethods");
        getMethods(employee);
        System.out.println("call method useMethods");
        useMethods(employee);

    }
    public static void showFullInfo(Object obj){
        Class eClass = obj.getClass();
        Field[] fields = eClass.getDeclaredFields();

        for (Field f : fields){
            System.out.println(f.getName() + " " + f.getType());
        }
    }

    public static void getMethods(Object obj){
        Class eClass = obj.getClass();
        Method[] methods = eClass.getDeclaredMethods();
        for (Method m : methods){
            System.out.println("method: " + m.getName());
        }
        System.out.println(methods.length);
    }
    public static Method[] useMethods(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class eClass = obj.getClass();
        Method[] methods = eClass.getDeclaredMethods();
        for (Method m : methods){
            m.setAccessible(true);
            m.invoke(obj);
        }
        return methods;
    }
}

