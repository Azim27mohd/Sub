package utilities;

import java.util.NoSuchElementException;

/**
 * Interface for Queue ADT.
 */
public interface QueueADT<E> {

    /**
     * Inserts the specified element into this queue.
     *
     * @param element the element to add
     * @throws NullPointerException if the specified element is null
     */
    void enqueue(E element) throws NullPointerException;

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element removed from the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    E dequeue() throws NoSuchElementException;

    /**
     * Returns the element at the front of this queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    E peek() throws NoSuchElementException;

    /**
     * Checks if this queue is empty.
     *
     * @return true if this queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    int size();

    Iterator<Integer> iterator();
}
