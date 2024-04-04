package utilities;

import java.util.Iterator; // Import the Iterator interface
import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        if (index == 0) {
            addFirst(toAdd);
        } else if (index == size) {
            addLast(toAdd);
        } else {
            Node<E> newNode = new Node<>(toAdd);
            Node<E> current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
        return true;
    }

    @Override
    public boolean add(E toAdd) {
        return addLast(toAdd);
    }

    private boolean addFirst(E toAdd) {
        Node<E> newNode = new Node<>(toAdd);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    boolean addLast(E toAdd) {
        Node<E> newNode = new Node<>(toAdd);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) {
        java.util.Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            addLast(iterator.next());
        }
        return true;
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        Node<E> nodeToRemove = getNode(index);
        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
        size--;
        return nodeToRemove.data;
    }

    @Override
    public E remove(E toRemove) {
        Node<E> current = head;
        while (current != null) {
            if (toRemove.equals(current.data)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) {
        Node<E> nodeToChange = getNode(index);
        E oldValue = nodeToChange.data;
        nodeToChange.data = toChange;
        return oldValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) {
        Node<E> current = head;
        while (current != null) {
            if (toFind.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) {
        if (toHold.length < size) {
            toHold = (E[]) java.util.Arrays.copyOf(toHold, size);
        }
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            toHold[index++] = current.data;
            current = current.next;
        }
        if (toHold.length > size) {
            toHold[size] = null;
        }
        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        Node<E> current = head;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyDLLIterator();
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private class MyDLLIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    public E removeFirst() {
        return null;
    }
}
