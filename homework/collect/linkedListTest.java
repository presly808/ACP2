package homeWork.collect;// Created by Sergey on 02.09.2014.

import homeWork.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class linkedListTest {
    public static void main(String[] args) {
        Employee[] emplSimpleArray = new Employee[2];
        emplSimpleArray[0] = new Employee("Vasyl", 123, 22);
        emplSimpleArray[1] =  new Employee("Petro", 4321, 33);

        Collection empLkdLst= new LinkedList<Employee>();
        Collections.addAll(empLkdLst, emplSimpleArray);
        Iterator itr = empLkdLst.iterator();

        for (Object e:empLkdLst){
            System.out.println(((Employee) e).getName() + " " + ((Employee) e).getSalary() + " " + ((Employee) e).getAge());
        }
        itr.next();
        itr.next();
        itr.remove();
        for (Object e:empLkdLst){
            System.out.println(((Employee) e).getName() + " " + ((Employee) e).getSalary() + " " + ((Employee) e).getAge());
        }
    }
}