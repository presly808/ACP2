package ua.artcode.week3.week3.day2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by 1 on 12.09.14.
 */
public class TestP {
    Prot prot;
    @Before
    public void init(){
        prot = new Prot(10);
        System.out.println("Before tests");
    }
    @After
    public void titi(){
        System.out.println("After tests");
    }
    @Test
    public void addTest(){
        prot.add(12);
        assertEquals(22,prot.getAmount());
        System.out.println("Add test");
    }
    @Test
    public void reoveTest(){
        prot.remove(7);
        assertEquals(3,prot.getAmount());
        System.out.println("Remove test");
    }
}
