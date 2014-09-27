package ua.artcode.week1.home;

import java.util.Iterator;

/**
 * Created by admin on 27.08.2014.
 */
public class MySet<E> implements Iterable<E> {

    private Link[] mas;

    public MySet() {
        this.mas = new Link[16];
    }

    public boolean add(E obj) {
        int pos = Math.abs(obj.hashCode() % mas.length);

        if (mas[pos] != null) {
            Link iter = mas[pos];
            while (iter.next != null) {
                if (iter.value.equals(obj)) {
                    return false;
                }
            }
            iter.next = new Link(obj, null);
        } else {
            mas[pos] = new Link(obj, null);
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new MySetIterator();
    }


    private static class Link<T> {
        T value;
        Link<T> next;

        private Link(T value, Link<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private class MySetIterator implements Iterator<E> {

        private Link<E> iterNext;
        private int bucket;

        private MySetIterator() {
            while (bucket < mas.length && (iterNext =  mas[bucket++]) == null);
        }

        @Override
        public boolean hasNext() {
            return iterNext != null;
        }

        @Override
        public E next() {
            Link<E> temp = iterNext;

            if(temp == null){
                return null;
            }

            if(iterNext.next != null){
                iterNext = iterNext.next;
            } else {
                while (bucket < mas.length && (iterNext =  mas[bucket++]) == null){
                }

                if(bucket >= mas.length){
                    iterNext = null;
                }
            }

            return temp.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
