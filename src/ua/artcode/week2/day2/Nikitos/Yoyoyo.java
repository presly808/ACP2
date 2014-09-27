package ua.artcode.week2.day2.Nikitos;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by 1 on 31.08.14.
 */
public class Yoyoyo {
    public static void main(String[] args) throws IOException {
        Car c1 = new Car("Opel", 120);
        Class car = c1.getClass();
        System.out.println(car);
        Field [] fields = car.getDeclaredFields();
        for (Field f : fields){
            System.out.println(f.getName().toString());
        }



    }
}
