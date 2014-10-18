package ua.artcode.week8.day1;

/**
 * Created by admin on 18.10.2014.
 */
public class Company {

    private String name;
    private int employeeCount;

    public Company() {
    }

    public Company(String name, int employeeCount) {
        this.name = name;
        this.employeeCount = employeeCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
