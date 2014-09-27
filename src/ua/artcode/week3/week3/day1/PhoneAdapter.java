package ua.artcode.week3.week3.day1;

/**
 * Created by 1 on 06.09.14.
 */
public class PhoneAdapter implements Iphone {
    private OldPhone phone;

    public PhoneAdapter(OldPhone phone) {
        this.phone = phone;
    }

    @Override
    public void superCall() {
        phone.call();

    }
}
