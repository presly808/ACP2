package ua.artcode.week3.day1.tests;

import org.junit.*;

import java.util.ArrayList;

public class TestArrayList {

    private ArrayList arrayList;

    @Before
    public void setUp(){
        arrayList = new ArrayList();
    }

    @Test
    public void testOneAddContains(){
        arrayList.add(1);
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void testEmptyArray(){
        Assert.assertEquals(true, arrayList.isEmpty());
    }

    @Test
    public void testClear(){
        arrayList.add(1);
        arrayList.add(2);

        arrayList.clear();
        Assert.assertEquals(true, arrayList.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithEmptyList(){
        arrayList.get(0);
    }

    @Test(timeout = 10000)
    public void testSinusTimeOut(){
        for (int i =0; i < 10000000; i++){
            Math.sin(i);
        }
    }

    @After
    public void tearDown(){
        arrayList = null;
    }


}
