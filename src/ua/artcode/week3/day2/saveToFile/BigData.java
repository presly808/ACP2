package ua.artcode.week3.day2.saveToFile;

import ua.artcode.week3.day2.ForSave;

public class BigData {

    @ForSave(path = "description.txt")
    private String desription;

    @ForSave(path = "count.txt")
    private Integer count;
    private Double ammount;

    public BigData() {
    }

    public BigData(String desription, Integer count, Double ammount) {
        this.desription = desription;
        this.count = count;
        this.ammount = ammount;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }
}
