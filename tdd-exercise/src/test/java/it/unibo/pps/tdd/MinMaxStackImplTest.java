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

    @Test
    public void stackSizeShouldIncreaseOnPush() {
        final int pushValue = 1;
        final int finalSize = this.initialStackSize + 1;

        this.stack.push(pushValue);
        assertEquals(finalSize, this.stack.size());
    }

    @Test
    public void popShouldReturnAddedValue() {
        final int pushValue = 1;

        this.stack.push(pushValue);

        final int getValueByPop = this.stack.pop();
        assertEquals(pushValue, getValueByPop);
    }

    @Test
    public void peekShouldReturnAddedValue() {
        final int pushValue = 1;

        this.stack.push(pushValue);

        final int getValueByPeek = this.stack.peek();
        assertEquals(pushValue, getValueByPeek);
    }

    @Test
    public void popShouldRemoveAddedValue() {
        final int pushValue = 1;

        this.stack.push(pushValue);
        this.stack.pop();

        assertEquals(this.initialStackSize, this.stack.size());
    }

    @Test
    public void getMinShouldFailOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> this.stack.getMin());
    }

    @Test
    public void getMaxShouldFailOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> this.stack.getMax());
    }
}