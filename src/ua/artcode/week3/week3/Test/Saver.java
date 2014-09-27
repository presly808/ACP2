package ua.artcode.week3.week3.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 1 on 07.09.14.
 */
public class Saver {
    private BigPart part;

    public BigPart getPart() {
        return part;
    }

    public void setPart(BigPart part) {
        this.part = part;
    }
    public Saver() {
    }
    public Saver(BigPart part) {

        this.part = part;
    }
    public void go(){
        Class cl = part.getClass();
        Field [] fields = cl.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            ForSave forSave = field.getAnnotation(ForSave.class);
            try {
                OutputStream stream = new FileOutputStream(forSave.name());
                PrintWriter writer = new PrintWriter(stream);
                Object o = (Object) part;

                    writer.print(field.getName() + "="+ field.get(o));

                writer.close();
                stream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public void load(){
        Class cl = BigPart.class;
        ArrayList<String> values = new ArrayList<String>();
        Field [] fields = cl.getDeclaredFields();
        for(Field f: fields){
            f.setAccessible(true);
            ForSave forSave = f.getAnnotation(ForSave.class);
            try {
                InputStream stream = new FileInputStream(forSave.name());
                Scanner scanner = new Scanner(stream);
                String s = scanner.nextLine();
                String [] temp = s.split("=");
                values.add(temp[1]);
                scanner.close();
                stream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        part.setDesc(values.get(0));
        part.setCount(Integer.parseInt(values.get(1)));
        part.setAmount(Double.parseDouble(values.get(2)));


    }


}
