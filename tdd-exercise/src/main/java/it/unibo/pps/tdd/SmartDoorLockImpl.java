package it.unibo.pps.tdd;

public class SmartDoorLockImpl implements SmartDoorLock {

    private boolean isPinSet = false;

    @Override
    public void setPin(int pin) {
        if (pin <= 0) {
            throw new IllegalArgumentException("pin must be positive number");
        }

        int pinLength = String.valueOf(pin).length();
        if (pinLength != 4) {
            throw new IllegalArgumentException("pin must be 4 characters long");
        }

    }

    @Override
    public void unlock(int pin) {
        if (!isPinSet) {
            throw new IllegalStateException("no pin set");
        }
    }

    @Override
    public void lock() {
        if (!isPinSet) {
            throw new IllegalStateException("no pin set");
        }
    }

    @Override
    public boolean isLocked() {
        return false;
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
