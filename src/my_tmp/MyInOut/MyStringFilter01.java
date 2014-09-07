package my_tmp.MyInOut;

/**
 * Created by Admin on 06.09.14.
 */
public class MyStringFilter01 {
   /* public MyStringFilter01(String str){

    }*/

    public String filter(String str){
        char[] chars = str.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++){
            if( Character.isDigit(chars[i]) ){
                chars[i] = 0;
            }
            if( chars[i] == 'A'){
                chars[i] = 'Q';
            }
        }
        String newString = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) newString += chars[i];
        }
        return newString;
    }
}
