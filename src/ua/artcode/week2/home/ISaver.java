package ua.artcode.week2.home;

import java.io.FileNotFoundException;

/**
 * Created by admin on 06.09.2014.
 */
public interface ISaver {

    public void save(Object o, String path) throws FileNotFoundException;

    public Object load(String path) throws FileNotFoundException;

}
