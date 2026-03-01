package it.unibo.pps.tdd;

import java.util.ArrayList;

public class CircularQueueImpl implements CircularQueue {

    private final ArrayList<Integer> queue = new ArrayList<Integer>();
    private int max_capacity;

    public CircularQueueImpl(int max_capacity) {
        if (max_capacity < 0) {
            throw new IllegalArgumentException("max capacity cannot be zero or negative");
        }
        this.max_capacity = max_capacity;
    }

    @Override
    public void push(int value) {
        if (this.size() == this.max_capacity) {
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
        return max_capacity;
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
