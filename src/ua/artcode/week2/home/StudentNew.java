package ua.artcode.week2.home;

public class StudentNew {

    private String name;
    private int course;
    private int age;


    public StudentNew() {
        this.name = "N/A";
        this.course = -1;
        this.age = -1;
    }

    public StudentNew(String name, int course, int age) {
        this.name = name;
        this.course = course;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentNew{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", age=" + age +
                '}';
    }
}
