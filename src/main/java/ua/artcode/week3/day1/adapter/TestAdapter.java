package ua.artcode.week3.day1.adapter;

/**
 * Created by admin on 06.09.2014.
 */
public class TestAdapter {


    public static void main(String[] args) {
        OldPhone oldPhone = new OldPhone();
        ModernPhone modernPhone = new ModernPhone();

        PhoneService phoneService = new PhoneService();
        phoneService.testCall(modernPhone);

        OldPhoneAdapter oldPhoneAdapter = new OldPhoneAdapter(oldPhone);
        phoneService.testCall(oldPhoneAdapter);

    }
}
