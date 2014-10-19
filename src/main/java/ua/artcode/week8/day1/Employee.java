package ua.artcode.week8.day1;

/**
 * Created by admin on 18.10.2014.
 */
public class Employee {

    private String name;
    private Company company;

    public Employee() {
    }

    public Employee(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company=" + company +
                '}';
    }
}
