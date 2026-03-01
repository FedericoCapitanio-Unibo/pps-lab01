package it.unibo.pps.tdd;

import java.util.ArrayList;

public class MinMaxStackImpl implements MinMaxStack {

    private ArrayList<Integer> stack = new ArrayList<Integer>();

    @Override
    public void push(int value) {
        this.stack.add(value);
    }

    private void emptyStackCheck() {
        if (stack.isEmpty()) {
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
        return 0;
    }

    @Override
    public int getMax() {
        emptyStackCheck();
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
