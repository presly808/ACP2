package ua.artcode.week3.day1;

import ua.artcode.week2.day2.reflection.Employee;

/**
 * Created by Vishn9 on 06.09.2014.
 */
public class WorkerAdapter implements ModernWorker {
    private Employee employee;

    public double getBigSalary(){
       return employee.getSalary();
    }
}
