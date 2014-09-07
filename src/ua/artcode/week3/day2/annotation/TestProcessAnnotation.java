package ua.artcode.week3.day2.annotation;

import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by admin on 07.09.2014.
 */
public class TestProcessAnnotation {


    private static Container container;
    private static String tempPath;
    private static int fieldsCount;

    @BeforeClass
    public static void beforeClass(){
        container = new Container("test data", 1234567);
        tempPath =  container.getClass().getAnnotation(ForSave.class).path();
        for(Field field : container.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(ForSave.class)){
                fieldsCount++;
            }
        }
    }


    @Test
    public void testSave() throws IOException, IllegalAccessException {
        ProcessAnnotation.processObject(container);
        File folder = new File(tempPath);
        Assert.assertEquals(true ,folder.exists());
        Assert.assertEquals(fieldsCount,folder.list().length);

    }

    @AfterClass
    public static void afterClass(){
        File root = new File(tempPath);
        root.delete();
    }

}
