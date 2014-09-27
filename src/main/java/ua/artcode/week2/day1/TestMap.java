package ua.artcode.week2.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by admin on 30.08.2014.
 */
public class TestMap {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1, "Serhii");
        map.put(2, "Andriy");
        map.put(3, "Vasia");


        System.out.println(map.get(1));

        for(Integer integer : map.keySet()){
            System.out.println(integer + " " + map.get(integer));
        }

        Set<Map.Entry<Integer, String>> entrySet =   map.entrySet();
        for(Map.Entry<Integer, String> entry : entrySet){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
