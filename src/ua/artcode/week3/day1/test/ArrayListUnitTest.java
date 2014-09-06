package ua.artcode.week3.day1.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Created by admin on 06.09.2014.
 */
public class ArrayListUnitTest {




    @Test
    public void testOneAddContains(){
        ArrayList al = new ArrayList();
        al.add(1);
        assertEquals(1, al.size());
    }

    @Test
    public void testEmptyArrayList(){
        ArrayList al = new ArrayList();
        assertEquals(false, al.isEmpty());
    }






}
