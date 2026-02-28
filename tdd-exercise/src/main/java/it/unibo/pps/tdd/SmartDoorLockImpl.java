package it.unibo.pps.tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private final int DEFAULT_PIN = -1;
    private int pin = DEFAULT_PIN;
    private boolean isLocked = false;

    @Override
    public void setPin(int pin) {
        if (this.isPinSet()) {
            throw new IllegalStateException("pin has already been set");
        }

        if (pin <= 0) {
            throw new IllegalArgumentException("pin must be positive number");
        }

        int pinLength = String.valueOf(pin).length();
        if (pinLength != 4) {
            throw new IllegalArgumentException("pin must be 4 characters long");
        }

        this.pin = pin;
        this.isLocked = true;

    }

    public boolean isPinSet() {
        return this.pin != DEFAULT_PIN;
    }

    @Override
    public void unlock(int pin) {
        if (!this.isPinSet()) {
            throw new IllegalStateException("no pin set");
        }
        this.isLocked = false;
    }

    @Override
    public void lock() {
        if (!this.isPinSet()) {
            throw new IllegalStateException("no pin set");
        }
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
