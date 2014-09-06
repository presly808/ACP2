package ua.artcode.week2.home;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Scanner;

public class SaveToFileByReflection {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, FileNotFoundException, ClassNotFoundException {

        StudentNew studentNew1 = new StudentNew();
        refSave(studentNew1);

        StudentNew studentNew = (StudentNew) refLoad("obj.txt");
        System.out.println(studentNew);



    }


    public static void refSave(Object o){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("obj.txt");
            Class cl = o.getClass();
            pw.println(cl);
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                pw.println(field.getName() + " " + field.get(o));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    public static Object refLoad(String path) throws FileNotFoundException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object obj = null;
        HashMap<String, String> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            hashMap.put(parts[0], parts[1]);
        }

        Class cl = Class.forName(hashMap.get("class"));
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

            switch (field.getType().toString()){
                case "String":{
                    field.set(obj, hashMap.get(field.getName()));
                    break;
                }

                case "Interger":
                case "int":{
                    int integr = Integer.parseInt(hashMap.get(field.getName()));
                    field.set(obj, integr);
                    break;
                }
                case "Float":
                case "float":{
                    float fl = Float.parseFloat(hashMap.get(field.getName()));
                    field.set(obj, fl);
                    break;
                }
                case "Double":
                case "double":{
                    double dbl = Double.parseDouble(hashMap.get(field.getName()));
                    field.set(obj, dbl);
                    break;
                }
                case "Long":
                case "long":{
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
                case "short":{
                    short sh = Short.parseShort(hashMap.get(field.getName()));
                    field.set(obj, sh);
                    break;
                }
                case "Byte":
                case "byte":{
                    byte bt = Byte.parseByte(hashMap.get(field.getName()));
                    field.set(obj, bt);
                    break;
                }

                default: break;
            }

        }


        return obj;
    }
}
