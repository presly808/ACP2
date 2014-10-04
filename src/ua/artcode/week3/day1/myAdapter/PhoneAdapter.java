package ua.artcode.week3.day1.myAdapter;

public class PhoneAdapter implements iModernPhone {
    OldPhone oldPhone;

    public PhoneAdapter(OldPhone oldPhone) {
        this.oldPhone = oldPhone;
    }

    @Override
    public void superCall() {
        oldPhone.call();
    }
}
