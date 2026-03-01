package it.unibo.pps.tdd;

import java.util.ArrayList;

public class MinMaxStackImpl implements MinMaxStack {

    private final ArrayList<Integer> stack = new ArrayList<Integer>();
    private final int DEFAULT_MIN_VALUE = -1;
    private final int DEFAULT_MAX_VALUE = -1;
    private int minValue = DEFAULT_MIN_VALUE;
    private int maxValue = DEFAULT_MAX_VALUE;

    @Override
    public void push(int value) {
        if (this.minValue == DEFAULT_MIN_VALUE || value < this.minValue) {
            this.minValue = value;
        }

        if (this.maxValue == DEFAULT_MAX_VALUE || value > this.maxValue) {
            this.maxValue = value;
        }

        this.stack.add(value);
    }

    private void emptyStackCheck() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
    }

    @Override
    public int pop() {
        emptyStackCheck();
        final int lastValue = this.stack.getLast();
        this.stack.removeLast();
        return lastValue;
    }

    @Override
    public int peek() {
        emptyStackCheck();
        return this.stack.getLast();
    }

    @Override
    public int getMin() {
        emptyStackCheck();
        return this.minValue;
    }

    @Override
    public int getMax() {
        emptyStackCheck();
        return this.maxValue;
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
