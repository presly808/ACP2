package ua.artcode.week1.day2.collec;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by admin on 24.08.2014.
 */

public class MyHashtable<E> implements Set<E> {

    private Object[] mas = new Object[16];
    private double loadFactor = 0.75;

    public int hash(Object o){
        int i = o.hashCode()%mas.length;
        return Math.abs(i);
    }

    @Override
    public int size() {
        int iter = 0;
        for (Object o : mas){
            if (o != null){
                iter++;
            }
        }
        return iter;
    }

    @Override
    public boolean isEmpty() {
        for(Object x: mas){
            if (x != null)
                return false;
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (Object x : mas){
            if (x != null && x.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[mas.length];
        for (int i = 0; i < mas.length; i++){
            arr[i] = mas[i];
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
            mas[hash(e)] = e;
            return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int j = 0; j < mas.length; j++){
            if (mas[j].equals(o)){
                mas[j] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
    /*
        Object[] masTmp = new Object[mas.length];
        masTmp = mas.clone();
        mas = new Object[mas.length << 1];
        mas = masTmp.clone();
        */
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < mas.length; i++){
            mas[i] = null;
        }
        System.out.println("Clear is ok.");
    }
    @Override
    public String toString() {
        for (int i = 0; i < mas.length; i++){
            if (mas[i] != null)
            System.out.println(mas[i].toString() + " hash= " + hash(mas[i]));
        }
        return "ok";
    }
}
