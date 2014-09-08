package ua.kpi.alg;

import java.util.*;

/**
 * Created by admin on 08.09.2014.
 */
public class CheckerBinary {

    public Map<Integer, Map<int[], List<Integer>>> map;

    public CheckerBinary(){
        map = new HashMap<>();
        init();
    }

    private void init(){
        for (int i = 1; i < 3; i++) {
            Map<int[], List<Integer>> temp = new HashMap<>();
            int[][] table = genTableOfBits(1);
            for(int[] key : table){
                temp.put(key, new ArrayList<Integer>());
            }
            map.put(i, temp);
        }
    }

    public void check(int bitCount, int[] mas){


    }

    public void checkSimple(int keyBit, int[] pivot, int[] bits){
        Map<int[], List<Integer>> temp = map.get(keyBit);
        int len = pivot.length;
        int last = -1;
        for(int i = 0; i < bits.length - pivot.length; i++){
            int[] mas = Arrays.copyOfRange(bits, i, len);
            last = bits[len];
            List<Integer> list = temp.get(mas);
            list.add(last);
        }
    }



    public boolean equalsArrays(int[] mas, int[] source, int lRange, int rRange){
        for(int i = 0, j = lRange; i < mas.length && j < rRange; i++, j++){
            if(mas[i] != source[j]){
                return false;
            }
        }
        return true;
    }

    public int[][] genTableOfBits(int count){
        int size = (int)Math.pow(2, count);
        int[][] res = new int[size][count];
        for(int i = 0; i < size; i++){
            res[i] = getBinary(i, count);
        }
        return res;
    }

    public int[] getBinary(int dec, int bitCount){
        String binary = Integer.toBinaryString(dec);
        binary = addToLeft(binary, '0', bitCount - binary.length());
        int[] mas = new int[binary.length()];
        for(int i = 0; i < mas.length; i++){
            mas[i] = binary.charAt(i) == '0' ? 0 : 1;
        }
        return mas;
    }

    private static String addToLeft(String src, char a, int count){
        while (count-- > 0){
            src = a + src;
        }
        return src;
    }

    public static String deepToString(int[][] table){
        StringBuilder sb = new StringBuilder();
        sb.append("*******************BIT TABLE" + "\n");
        for(int i = 0; i < table.length; i++){
            sb.append(Arrays.toString(table[i]) + "\n");
        }
        sb.append("*******************END TABLE");
        return sb.toString();
    }


}
