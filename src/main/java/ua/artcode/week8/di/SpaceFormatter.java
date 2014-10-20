package ua.artcode.week8.di;

import java.lang.reflect.Field;

/**
 * Created by admin on 19.10.2014.
 */
public class SpaceFormatter implements IFormatter {
    @Override
    public String format(Object obj) {
        Class cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for(Field f : fields){
            f.setAccessible(true);
            try {
                sb.append(f.get(obj).toString() + "  ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
