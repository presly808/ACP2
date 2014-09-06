package ua.artcode.week2.day2.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by admin on 31.08.2014.
 *
public class TestReflection {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Employee employee = new Employee("Ivan", 2000, 28);

        System.out.println(employee);
        showFullInfo(employee);

        System.out.println(employee);

        Class cl = Class.forName("ua.artcode.week2.day2.reflection.Employee");
        Employee empl = (Employee) cl.newInstance();
        System.out.println(empl);

        cl.getModifiers()


    }

    public static void showFullInfo(Object obj){
        Class eClass = obj.getClass();
        System.out.println("class name = " +  eClass.getName());
        System.out.println("super = " + eClass.getSuperclass().getName());


        Field[] fields = eClass.getDeclaredFields();
        for(Field f : fields){
            System.out.println(f.getType().getName() + " " + f.getName());
        }

        for(Method m : eClass.getDeclaredMethods()){
            System.out.println(m.getName());
        }

        try {
            Field field = eClass.getDeclaredField("name");
            field.setAccessible(true);
            field.set(obj, "Andriy");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
*/