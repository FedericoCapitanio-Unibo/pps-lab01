package it.unibo.pps.tdd;

import java.util.ArrayList;

public class CircularQueueImpl implements CircularQueue {

    private final ArrayList<Integer> queue = new ArrayList<Integer>();
    private final int MAX_CAPACITY = 5;

    @Override
    public void push(int value) {
        if (this.size() == this.MAX_CAPACITY) {
            this.remove();
            this.queue.addFirst(value);
        } else {
            this.queue.addLast(value);
        }
    }

    private void emptyQueueCheck() {
        if (this.queue.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
    }

    @Override
    public void remove() {
        this.emptyQueueCheck();
        this.queue.removeFirst();
    }

    @Override
    public int maxCapacity() {
        return MAX_CAPACITY;
    }

    @Override
    public int peek() {
        this.emptyQueueCheck();
        return this.queue.getFirst();
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
