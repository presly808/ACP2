package ua.artcode.week1.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 23.08.2014.
 */
//TODO : use cache
public class IFactRecursionImpl implements IFactRecursion {

    private int recCounter = 0;
    private List<Integer> cache = new ArrayList<Integer>(100); // TODO replace by map

    @Override
    public Integer rec(Integer value) {
        recCounter++;
        if(value < 2){
            return 1;
        }

        int current = value;

        int returned = rec(value - 1);

        cache.add(returned);

        int operationRes = current * returned;
        recCounter--;

        System.out.println(makeInfo(recCounter, current, returned, operationRes));

        return operationRes; // Autoboxing, unboxing - Wrappers (Integer, Double)
    }

    private String makeInfo(int deep, int current, int returned, int res){
        String seq = makeSpaces(deep);
        return seq += " deep = " + deep + "; current value =  " + current + "; returned = " + returned +
                " result of rec multiply = " + res;
    }

    private String makeSpaces(int num){
        String word = ""; // TODO : Immutable, refactor StringBuilder
        for(int i = 0; i < num; i++){
            word += " ";
        }
        return word;
    }

    public void showCache(){
        for(Integer integer : cache){
            System.out.print(integer + " ");
        }
    }

}
