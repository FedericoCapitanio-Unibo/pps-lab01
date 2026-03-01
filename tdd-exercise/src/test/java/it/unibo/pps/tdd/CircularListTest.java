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
        final int initialSize = 0;

        assertEquals(initialSize, this.queue.size());
    }

    @Test
    public void shouldNotRemoveOnEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> this.queue.remove());
    }

}
