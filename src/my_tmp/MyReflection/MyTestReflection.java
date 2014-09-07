package my_tmp.MyReflection;

import java.io.*;
import java.lang.reflect.*;

/**
 * Created by Admin on 31.08.14.
 */
public class MyTestReflection {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, FileNotFoundException, IOException, ClassNotFoundException {
        String file = "d://java//ACP2//MyReflection.txt";
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        MyEmployee employee = new MyEmployee("Jack", 2000, 30);
        showFullInfo(employee);
        useMethods(employee);
        Field[] fields = getFields(employee);
        Method[] methods = getMethods(employee);
        System.out.println(fields[0].toString());
        oos.writeObject(employee);
        oos.flush();
        oos.close();
        MyEmployee fromFileEmp = (MyEmployee) ois.readObject();
        fromFileEmp.sayHello();


    }

    public static void showFullInfo(Object obj){
        Class eClass = obj.getClass();
        System.out.println("class: " + eClass.getName());
        System.out.println("super: " + eClass.getSuperclass().getName());
        getFields(obj);
        getMethods(obj);
    }

    public static Field[] getFields(Object obj){
        Class eClass = obj.getClass();
        Field[] fields = eClass.getDeclaredFields();
        System.out.println("fields:");
        for (Field f : fields){
            System.out.println(f.getName() + " " + f.getType());
        }
        return fields;
    }

    public static Method[] getMethods(Object obj){
        Class eClass = obj.getClass();
        Method[] methods = eClass.getDeclaredMethods();
        System.out.println("methods: ");
        for (Method m : methods){
            System.out.println("method: " + m.getName() + ", return type(" + m.getReturnType() + "), " +
                    "modifier(" + getModifier(m.getModifiers()) + ")");
        }
        System.out.println("in object: " + methods.length + " methods");
        return methods;
    }
    public static String getModifier(int i){
        if (i == 1) return "public";
        else if (i == 2) return "private";
        else return "protected";
    }

    public static void useMethods(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class eClass = obj.getClass();
        Method[] methods = eClass.getDeclaredMethods();
        System.out.println("useMethods: ");
        for (Method m : methods){
            m.setAccessible(true);
            System.out.println("method: " + m.getName() + " -> " + m.invoke(obj) + ", access: " + m.isAccessible());
        }
    }
}

