package ua.kpi.alg;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 08.09.2014.
 */
public class TestBinary {

    public static void main(String[] args) {
        CheckerBinary checkerBinary = new CheckerBinary();
        int[][] table = checkerBinary.genTableOfBits(3);
        System.out.println(CheckerBinary.deepToString(table));

        int bitCount = 1;

        checkerBinary.checkSimple(bitCount, new int[1], new int[]{1,0,1,0,1,0});

        Map<int[], List<Integer>> map = checkerBinary.map.get(bitCount);
        for(Map.Entry<int[], List<Integer>> entry : map.entrySet()){
            System.out.println(Arrays.toString(entry.getKey()) + "*****" + entry.getValue().toString());
        }
    }
}
