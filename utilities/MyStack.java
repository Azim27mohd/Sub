package utilities;

import java.util.EmptyStackException;

public class MyStack<E> implements StackADT<E> {

    private MyArrayList<E> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    // Implementing Iterator interface for the stack
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {
        private int currentIndex = size() - 1;

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new EmptyStackException();
            }
            return list.get(currentIndex--);
        }
    }
}
