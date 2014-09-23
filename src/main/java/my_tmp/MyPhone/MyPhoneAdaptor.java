package my_tmp.MyPhone;

/**
 * Created by Admin on 06.09.14.
 */
public class MyPhoneAdaptor extends MyModernPhoneClass {
    @Override
    public void superCall() {
        MyOldPhone op = new MyOldPhone();
        op.call();
    }
}
