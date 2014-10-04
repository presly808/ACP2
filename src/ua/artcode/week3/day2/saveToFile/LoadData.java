package ua.artcode.week3.day2.saveToFile;

import ua.artcode.week3.day2.ForSave;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Scanner;

public class LoadData {

    public static Object refLoad(String path) throws FileNotFoundException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object obj = null;
        HashMap<String, String> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            hashMap.put(parts[0], parts[1]);
        }

        Class cl = Class.forName("BigData.class");
        obj = cl.newInstance();
        for (Field field : cl.getDeclaredFields()){
            field.setAccessible(true);
            /*switch (field.getName()){
                case "name":{
                    field.set(obj, hashMap.get(field.getName()));
                    break;
                }
                case "course":{
                    int course = Integer.parseInt(hashMap.get("course"));
                    field.set(obj, course);
                    break;
                }
                case "age":{
                    int age = Integer.parseInt(hashMap.get("age"));
                    field.set(obj, age);
                    break;
                }

                default:{
                    break;
                }
            }*/
            if (field.isAnnotationPresent(ForSave.class)) {
                switch (field.getType().toString()) {
                    case "String": {
                        field.set(obj, hashMap.get(field.getName()));
                        break;
                    }

                    case "Interger":
                    case "int": {
                        int integr = Integer.parseInt(hashMap.get(field.getName()));
                        field.set(obj, integr);
                        break;
                    }
                    case "Float":
                    case "float": {
                        float fl = Float.parseFloat(hashMap.get(field.getName()));
                        field.set(obj, fl);
                        break;
                    }
                    case "Double":
                    case "double": {
                        double dbl = Double.parseDouble(hashMap.get(field.getName()));
                        field.set(obj, dbl);
                        break;
                    }
                    case "Long":
                    case "long": {
                        long lng = Long.parseLong(hashMap.get(field.getName()));
                        field.set(obj, lng);
                        break;
                    }
                    case "Character":
                    case "char": {
                        char ch = hashMap.get(field.getName()).charAt(0);
                        field.set(obj, ch);
                        break;
                    }
                    case "Short":
                    case "short": {
                        short sh = Short.parseShort(hashMap.get(field.getName()));
                        field.set(obj, sh);
                        break;
                    }
                    case "Byte":
                    case "byte": {
                        byte bt = Byte.parseByte(hashMap.get(field.getName()));
                        field.set(obj, bt);
                        break;
                    }

                    default:
                        break;
                }
            }
        }


        return obj;
    }
}
