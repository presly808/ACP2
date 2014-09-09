package ua.artcode.week3.day1.adapter;

/**
 * Created by admin on 06.09.2014.
 */
public class OldPhoneAdapter extends ModernPhone {

    private OldPhone oldPhone;

    public OldPhoneAdapter(OldPhone oldPhone) {
        this.oldPhone = oldPhone;
    }

    @Override
    public void modernCall() {
        oldPhone.call();
    }
}
