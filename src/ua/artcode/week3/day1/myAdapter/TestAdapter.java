package ua.artcode.week3.day1.myAdapter;

public class TestAdapter {

    public static void main(String[] args) {
        OldPhone oldPhone = new OldPhone();
        Service service = new Service();

        service.repair(new PhoneAdapter(oldPhone));
    }

}
