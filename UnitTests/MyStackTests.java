package UnitTests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

// Import statements for StackADT and MyStack
import utilities.StackADT;
import utilities.MyStack;

public class MyStackTests {

    private StackADT<Integer> stack;

    @Before
    public void setUp() {
        // Initialize stack with MyStack implementation
        stack = new MyStack<>();
    }

    @Test
    public void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop().intValue());
        assertEquals(2, stack.pop().intValue());
        assertEquals(1, stack.pop().intValue());
    }

    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.peek().intValue());
        assertEquals(2, stack.peek().intValue()); // Peek again, should be the same
        assertEquals(2, stack.pop().intValue()); // Pop after peek, should still be 2
    }

    @Test(expected = EmptyStackException.class)
    public void testPopOnEmptyStack() {
        assertTrue(stack.isEmpty());
        stack.pop();
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekOnEmptyStack() {
        assertTrue(stack.isEmpty());
        stack.peek();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }
}
