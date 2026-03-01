package it.unibo.pps.tdd;

import java.util.ArrayList;

public class MinMaxStackImpl implements MinMaxStack {

    private ArrayList<Integer> stack = new ArrayList<Integer>();

    @Override
    public void push(int value) {
        this.stack.add(value);
    }

    @Override
    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        final int lastValue = this.stack.getLast();
        this.stack.removeLast();
        return lastValue;
    }

    @Override
    public int peek() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }

        return this.stack.getLast();
    }

    @Override
    public int getMin() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        return 0;
    }

    @Override
    public int getMax() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
