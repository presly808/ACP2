package ua.artcode.week3.week3.Test;

/**
 * Created by 1 on 07.09.14.
 */
public class BigPart {
    @ForSave(name = "aaa.txt")
    private String desc;
    @ForSave(name = "baa.txt")
    private Integer count;
    @ForSave(name = "caa.txt")
    private Double amount;

    public BigPart(String desc, Integer count, Double amount) {
        this.desc = desc;
        this.count = count;
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
