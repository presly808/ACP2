package ua.artcode.week8.di;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 19.10.2014.
 */
public class TestDI {


    public static void main(String[] args) throws IOException {
        Container container = new Container();
        DependencyInjector di = new DependencyInjectorImpl();

        di.process(container);
        System.out.println(container.getFormatter());
    }
}
