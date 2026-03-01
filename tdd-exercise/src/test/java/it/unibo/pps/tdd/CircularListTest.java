package it.unibo.pps.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularQueueImpl queue;
    private final int initialSize = 0;

    @BeforeEach
    public void init() {
        this.queue = new CircularQueueImpl();
    }

    @Test
    public void queueShouldBeEmpty() {
        final CircularQueueImpl queue = new CircularQueueImpl();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void sizeShouldBeZero() {
        assertEquals(this.initialSize, this.queue.size());
    }

    @Test
    public void shouldNotRemoveOnEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> this.queue.remove());
    }

    @Test
    public void shouldNotPeekOnEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> this.queue.peek());
    }

    @Test
    public void sizeShouldIncreaseOnPush() {
        final int pushValue = 1;
        final int queueSizeAfterPush = this.initialSize + 1;

        this.queue.push(pushValue);
        assertEquals(queueSizeAfterPush, this.queue.size());
    }

    @Test
    public void sizeShouldDecreaseOnRemove() {
        final int pushValue = 1;

        this.queue.push(pushValue);
        this.queue.remove();
        assertEquals(this.initialSize, this.queue.size());
    }

}
