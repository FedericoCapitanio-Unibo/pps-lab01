package it.unibo.pps.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLock lock;

    @Test
    public void lockShouldNotBeLocked() {

        lock = new SmartDoorLockImpl();
        assertFalse(lock.isLocked());
    }

    @Test
    public void lockShouldNotBeBlocked() {

        lock = new SmartDoorLockImpl();
        assertFalse(lock.isBlocked());

    }

}
