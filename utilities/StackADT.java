package utilities;

import java.util.EmptyStackException;

/**
 * Interface for Stack ADT.
 */
public interface StackADT<E> {

    /**
     * Pushes an element onto the top of this stack.
     *
     * @param element the element to push
     * @throws NullPointerException if the specified element is null
     */
    void push(E element) throws NullPointerException;

    /**
     * Removes the element at the top of this stack and returns it.
     *
     * @return the element removed from the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    E pop() throws EmptyStackException;

    /**
     * Returns the element at the top of this stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    E peek() throws EmptyStackException;

    /**
     * Checks if this stack is empty.
     *
     * @return true if this stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    int size();
}
