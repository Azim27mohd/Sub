package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import utilities.QueueADT;
import utilities.Iterator;
import utilities.MyQueue;

public class MyQueueTests {

    private QueueADT<Integer> queue;

    @Before
    public void setUp() {
        queue = new MyQueue<>();
    }

    @Test
    public void testEnqueueDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, (int) queue.dequeue());
        assertEquals(3, (int) queue.dequeue());
    }

    @Test
    public void testPeek() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, (int) queue.peek());
        assertEquals(1, (int) queue.peek());
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeueEmpty() {
        queue.dequeue();
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekEmpty() {
        queue.peek();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testIterator() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, (int) iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, (int) iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElement() {
        Iterator<Integer> iterator = queue.iterator();
        iterator.next();
    }
}
