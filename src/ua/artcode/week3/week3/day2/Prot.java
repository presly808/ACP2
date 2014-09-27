package ua.artcode.week3.week3.day2;

import sun.org.mozilla.javascript.internal.ast.EmptyExpression;

/**
 * Created by 1 on 12.09.14.
 */
public class Prot {
    private int amount = 0;
    private String name;
    private double weight;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Prot(int amount) {

        this.amount = amount;
    }
    public void add(int i){
        amount += i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prot prot = (Prot) o;

        if (amount != prot.amount) return false;
        if (Double.compare(prot.weight, weight) != 0) return false;
        if (name != null ? !name.equals(prot.name) : prot.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = amount;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public void remove (int i){
        amount -= i;


    }
}
