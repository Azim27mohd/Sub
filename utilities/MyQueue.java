package utilities;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueADT<E> {

    private MyDLL<E> list;

    public MyQueue() {
        list = new MyDLL<>();
    }

    @Override
    public void enqueue(E element) throws NullPointerException {
        list.addLast(element);
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.removeFirst();
    }

    @Override
    public E peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public utilities.Iterator<Integer> iterator() {
        return (utilities.Iterator<Integer>) new MyQueueIterator();
    }

    private class MyQueueIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the queue");
            }
            return list.get(currentIndex++);
        }
    }
}
