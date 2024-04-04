package utilities;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than zero");
        }
        array = (E[]) new Object[initialCapacity];
        size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = Math.max(oldCapacity * 2, minCapacity);
            array = Arrays.copyOf(array, newCapacity);
        }
    }
    

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) {
        return add(size, toAdd);
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) {
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        return array[index];
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        E removedElement = array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null; // Let gc do its work
        return removedElement;
    }

    @Override
    public E remove(E toRemove) {
        for (int i = 0; i < size; i++) {
            if (toRemove.equals(array[i])) {
                return remove(i);
            }
        }
        return null; // Element not found
    }

    @Override
    public E set(int index, E toChange) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        E oldValue = array[index];
        array[index] = toChange;
        return oldValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) {
        for (int i = 0; i < size; i++) {
            if (toFind.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) {
        if (toHold.length < size) {
            // Create a new array of type E[] explicitly
            E[] result = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);
            System.arraycopy(array, 0, result, 0, size);
            return result;
        }
        System.arraycopy(array, 0, toHold, 0, size);
        if (toHold.length > size) {
            toHold[size] = null;
        }
        return toHold;
    }
    

    @Override
    public Object[] toArray() {
        return java.util.Arrays.copyOf(array, size);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            return array[currentIndex++];
        }
    }
}
