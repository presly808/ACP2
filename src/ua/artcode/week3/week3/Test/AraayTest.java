package ua.artcode.week3.week3.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by 1 on 06.09.14.
 */
public class AraayTest {

    private ArrayList al;


    @Test(timeout = 1000)
    public void testOneAddContains(){
        ArrayList al = new ArrayList();
        al.add(1);
        assertEquals(1,al.size());
    }

    @Test
    public void testEmptyArList(){
        ArrayList al = new ArrayList();
        assertEquals(true,al.isEmpty());
    }
    @Before //начальная ініціалізація перед тестом, запускается перед каждим тестом
    public void setUp(){
        al = new ArrayList();
    }
    @After
    public void tearDown(){
        al = null;
    }
    @Test
    public void testClear(){
        al.addAll(Arrays.asList("dfg","efrg","frgv"));
        al.clear();
        assertEquals(true,al.isEmpty());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithEmptyList(){
        al.get(0);
    }
}
