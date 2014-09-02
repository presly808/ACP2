package my_tmp.MyBinaryTree;

/**
 * Created by Admin on 01.09.14.
 */
public class SomeClass implements SomeInterface {

    private int num;
    private String str;

    public SomeClass(int i, String str){
        this.num = i;
        this.str = str;

    }

    public void print(){
        System.out.println("Hello");
    }
    @Override
    public void someMethod() {
        System.out.println("Some method");

    }
}
