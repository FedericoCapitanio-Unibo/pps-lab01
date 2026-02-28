package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLock lock;

    @BeforeEach
    public void init() {
        this.lock = new SmartDoorLockImpl();
    }

    @Test
    public void lockShouldNotBeLocked() {
        assertFalse(this.lock.isLocked());
    }

    @Test
    public void lockShouldNotBeBlocked() {
        assertFalse(this.lock.isBlocked());
    }

    @Test
    public void lockUnlockShouldFailIfNoPinIsSet() {
        final int testPin = 1234;
        assertThrows(IllegalStateException.class, () -> this.lock.unlock(testPin));
    }

    @Test
    public void lockLockShouldFailIfNoPinIsSet() {
        final int testPin = 1234;
        assertThrows(IllegalStateException.class, () -> this.lock.lock());
    }

    @Test
    public void lockPinShouldNotBeNegativeInteger() {
        final int testPin = -456;
        assertThrows(IllegalArgumentException.class, () -> this.lock.setPin(testPin));
    }

}
