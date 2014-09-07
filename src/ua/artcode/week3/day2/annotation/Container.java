package ua.artcode.week3.day2.annotation;

/**
 * Created by admin on 07.09.2014.
 */

@ForSave(path = "container")
public class Container {

    @ForSave(path = "desc.txt")
    private String desc;

    @ForSave(path = "count")
    private Integer count;

    public Container() {
    }

    public Container(String desc, Integer count) {
        this.desc = desc;
        this.count = count;
    }
}
