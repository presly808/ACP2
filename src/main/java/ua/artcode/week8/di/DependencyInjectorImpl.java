package ua.artcode.week8.di;

import ua.artcode.week3.day2.annotation.ForSave;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by admin on 19.10.2014.
 */
public class DependencyInjectorImpl implements DependencyInjector {

    private Properties properties;

    public DependencyInjectorImpl(String path) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public DependencyInjectorImpl() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("e:\\dev\\IDEA_Projects\\ACP2\\src\\main\\resources\\week8\\di\\desc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void process(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        for(Field f : fields){
            f.setAccessible(true);
            if(f.isAnnotationPresent(ForInject.class)){
                String key = f.getType().getCanonicalName();
                String value = properties.getProperty(key);
                try {
                    Class cl = Class.forName(value);
                    Object impl =  cl.newInstance();
                    f.set(o, impl);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
