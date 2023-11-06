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

    public IterableWithPolicyImpl(T[] array) {
        this.larray = new ArrayList<>(Arrays.asList(array));
    }

    public IterableWithPolicyImpl(T[] array, Predicate<T> predicate) {
        this.larray = new ArrayList<>(Arrays.asList(array));
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
            return currentIndex < larray.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return larray.get(currentIndex++);
        }
        
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }
    
}
