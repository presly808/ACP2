package tmp;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Admin on 30.08.14.
 */
public class MyTestMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<Integer, String>();
        map.put(1, "Serhy");
        map.put(2, "Andry");
        map.put(3, "Olga");


        System.out.println(map.get(1));

        for (Integer integer : map.keySet()){
            System.out.println(integer + " " + map.get(integer));
        }
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
