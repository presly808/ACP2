package ua.artcode.week4.HM;

/**
 * Created by 1 on 23.09.14.
 */
public class Acc {
    private int money;

    @Override
    public String toString() {
        return
                "money= " + money;
    }

   synchronized public void plus(int s){
         money += s;

}

    public int getMoney() {

        return money;
    }

    public Acc(int money) {

        this.money = money;
    }
}
