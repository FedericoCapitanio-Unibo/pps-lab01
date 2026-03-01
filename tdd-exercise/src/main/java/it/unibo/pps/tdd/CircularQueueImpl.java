package it.unibo.pps.tdd;

import java.util.ArrayList;

public class CircularQueueImpl implements CircularQueue {

    private final ArrayList<Integer> queue = new ArrayList<Integer>();

    @Override
    public void push(int value) {

    }

    private void emptyStackCheck() {
        if (this.queue.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
    }

    @Override
    public void remove() {
        this.emptyStackCheck();
    }

    @Override
    public int maxCapacity() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return this.queue.size();
    }
}
