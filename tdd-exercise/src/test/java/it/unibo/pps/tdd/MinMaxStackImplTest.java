package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private MinMaxStackImpl stack;

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
        final int initialStackSize = 0;
        assertEquals(initialStackSize, this.stack.size());
    }

}