package ua.artcode.week3.week3.Test;

/**
 * Created by 1 on 07.09.14.
 */
public class SaveTest {
    public static void main(String[] args) {
        BigPart part = new BigPart("qwer",45,23.5);
        Saver saver = new Saver(part);
        saver.load();
    }
}
