package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private MinMaxStackImpl stack;
    private final int initialStackSize = 0;

    @BeforeEach
    public void init() {
        this.stack = new MinMaxStackImpl();
    }

    @Test
    public void stackShouldBeEmpty() {
        assertTrue(this.stack.isEmpty());
    }

    @Test
    public void stackSizeShouldBeZero() {
        assertEquals(this.initialStackSize, this.stack.size());
    }

    @Test
    public void popShouldFailIfStackIsEmpty() {
        assertThrows(IllegalStateException.class, () -> this.stack.pop());
    }

    @Test
    public void peekShouldFailIfStackIsEmpty() {
        assertThrows(IllegalStateException.class, () -> this.stack.peek());
    }

}