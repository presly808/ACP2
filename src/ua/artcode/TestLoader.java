package ua.artcode;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by admin on 01.09.2014.
 */
public class TestLoader {

    private static final String PATH = "dynamic/teacher_serhii/Task1_1.java";
    private static final String PATH_TASK1_CLASS = "dynamic/teacher_serhii/Task1_1Impl.java";

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        File root = new File("dynamic");
        File file = new File(PATH);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        compiler.run(null, null, null, PATH);
        compile();
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});

        Class cl = Class.forName("teacher_serhii.Task1_1", true, classLoader);
        System.out.println(cl.getName());
        Class impl = Class.forName("teacher_serhii.Task1_1Impl", true, classLoader);
        System.out.println(impl.getName());

        Object obj = impl.newInstance();
        impl.getMethod("go").invoke(obj);

        //compiler.run(null, null, null, PATH_TASK1_CLASS);



        //Object obj = cl.newInstance();
        //cl.getMethod("go").invoke(obj);



    }


    public static void compile() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("javac dynamic/teacher_serhii/*.java ");
    }
}
