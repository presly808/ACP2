package ua.artcode.week3.day1.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by admin on 06.09.2014.
 */
public class ArrayListUnitTest {

    private ArrayList al;

    @Before
    public void setUp(){
        al = new ArrayList();
    }

    @After
    public void tearDown(){
        al = null;
    }

    @Test(timeout = 10)
    public void testSinusTimeout(){
        for (int i = 0; i < 1000; i++) {
            Math.sin(i);
        }
    }

    @Test(timeout = 100)
    public void testOneAddContains(){
        al.add(1);
        assertEquals(1, al.size());
    }

    @Test
    public void testEmptyArrayList(){
        assertEquals(false, al.isEmpty());
    }

    @Test
    public void testClear(){
        al.addAll(Arrays.asList("New", "Element", "Size"));
        al.clear();
        assertEquals(true, al.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithEmpty(){
        al.get(0);

    }

}
