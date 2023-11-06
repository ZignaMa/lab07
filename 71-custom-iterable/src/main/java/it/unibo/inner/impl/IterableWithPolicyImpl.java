package it.unibo.inner.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import it.unibo.inner.api.IterableWithPolicy;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private List<T> larray;
    Predicate<T> predicate;

    public IterableWithPolicyImpl(T[] array, Predicate<T> predicate) {
        this.larray = new ArrayList<>(Arrays.asList(array));
        this.predicate= predicate;
    }

    public IterableWithPolicyImpl(T[] array) {
        this(array, new Predicate<>() {
                        @Override
                        public boolean test(T elem) {
                            return true;
                        }
                    });
    }
    
    @Override
    public Iterator<T> iterator() {
        return new FilterIterator();
    }


    @Override
    public String toString() {
        return "{" +
            " larray='" + getLarray() + "'" +
            "}";
    }


    private String getLarray() {
        var sb = new StringBuilder();
        sb.append("[");
        for (var elem : this.larray) {
            sb.append(elem + ", ");
        }
        sb.append("]");
        return sb.toString();
    }


    private class FilterIterator implements Iterator<T>{

        private int currentIndex=0;

        @Override
        public boolean hasNext() {
            while (currentIndex < larray.size()) {
                T elem = larray.get(currentIndex);
                if (predicate.test(elem)) {
                    return true;
                }
                currentIndex++;
            }
            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return larray.get(currentIndex++);
            }
            throw new NoSuchElementException();
        }
        
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.predicate=filter;
    }
    
}
