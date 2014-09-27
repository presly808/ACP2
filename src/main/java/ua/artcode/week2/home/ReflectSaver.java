package ua.artcode.week2.home;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by admin on 06.09.2014.
 */
public class ReflectSaver implements ISaver {

    @Override
    public void save(Object o, String path) throws FileNotFoundException {
        Class cl = o.getClass();
        try(PrintWriter pw = new PrintWriter(path)) {
            pw.print(makeStringForSave(o));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private String makeStringForSave(Object o) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        Class cl = o.getClass();
        sb.append("class=" + cl.getName()+ "\n");
        for(Field field : cl.getDeclaredFields()){
            field.setAccessible(true);
            sb.append(field.getName() + "=" + field.get(o).toString() + "\n");
        }
        return sb.toString();
    }

    @Override
    public Object load(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path));
        HashMap<String, String> hashMap = new HashMap<>(20);
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] parts = line.split("=");
            hashMap.put(parts[0], parts[1]);
        }
        return fromString(hashMap);
    }

    private Object fromString(Map<String, String> map){
        try {
            Class cl = Class.forName(map.get("class"));
            Object obj = cl.newInstance();
            for(Field field : cl.getDeclaredFields()){
                field.setAccessible(true);

                //field.set(obj, map.get(field.getName()));
            }
            return obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
