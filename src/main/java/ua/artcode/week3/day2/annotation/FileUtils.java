package ua.artcode.week3.day2.annotation;

import java.io.*;

/**
 * Created by admin on 07.09.2014.
 */
public class FileUtils {

    public static String temp_path;

    public static void save(String forSave, String path) throws IOException {
        /*File file = new File(temp_path);
        if(!file.exists()){file.createNewFile();}*/
        try(PrintWriter pw = new PrintWriter(new FileWriter(
                FileUtils.temp_path + File.separator + path))){
            pw.print(forSave);
            pw.flush();
            pw.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void preparePlace(String path){
        File folder = new File(path);

        if(!folder.exists()){
            folder.mkdir();
        }

        FileUtils.temp_path = path;

    }
}
