package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLockImpl lock;

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
        assertThrows(IllegalStateException.class, () -> this.lock.lock());
    }

    @Test
    public void lockPinShouldNotBeNegativeInteger() {
        final int testPin = -456;

        assertThrows(IllegalArgumentException.class, () -> this.lock.setPin(testPin));
    }

    @Test
    public void lockPinShouldBeFourDigitsLong() {
        final int testPin1 = 12;
        final int testPin2 = 123456;

        assertThrows(IllegalArgumentException.class, () -> this.lock.setPin(testPin1));
        assertThrows(IllegalArgumentException.class, () -> this.lock.setPin(testPin2));
    }

    @Test
    public void lockPinShouldNotBeSetIfAlreadySet() {
        final int testPin1 = 1234;
        final int testPin2 = 4567;

        this.lock.setPin(testPin1);
        assertThrows(IllegalStateException.class, () -> this.lock.setPin(testPin2));
    }

    @Test
    public void lockShouldBeLockedIfPinIsSet() {
        final int testPin = 1234;

        this.lock.setPin(testPin);
        assertTrue(this.lock.isLocked());
    }

    @Test
    public void lockShouldBeRemainLockedIfUnlockPinIsWrong() {
        final int rightTestPin = 1234;
        final int wrongTestPin = 5678;

        this.lock.setPin(rightTestPin);
        this.lock.unlock(wrongTestPin);
        assertTrue(this.lock.isLocked());
    }

    @Test
    public void lockShouldBeUnlocked() {
        final int testPin = 1234;

        this.lock.setPin(testPin);
        this.lock.unlock(testPin);
        assertFalse(this.lock.isLocked());
    }

    @Test
    public void lockCannotBeLockedIfAlreadyLocked() {
        final int testPin = 1234;

        this.lock.setPin(testPin);
        assertThrows(IllegalStateException.class, () -> this.lock.lock());
    }

    @Test
    public void lockCannotBeUnlockedIfAlreadyUnlocked() {
        final int testPin = 1234;

        this.lock.setPin(testPin);
        this.lock.unlock(testPin);
        assertThrows(IllegalStateException.class, () -> this.lock.unlock(testPin));
    }

    @Test
    public void lockShouldBeLockedAfterSetAndUnlock() {
        final int testPin = 1234;

        this.lock.setPin(testPin);
        this.lock.unlock(testPin);
        this.lock.lock();
        assertTrue(this.lock.isLocked());
    }

    @Test
    public void failedAttemptsShouldIncreaseOnUnlockFail() {
        final int rightTestPin = 1234;
        final int wrongTestPin = 5678;
        final int failedAttempts = this.lock.getFailedAttempts();

        this.lock.setPin(rightTestPin);
        this.lock.unlock(wrongTestPin);
        assertTrue(this.lock.getFailedAttempts() > failedAttempts);
    }

    @Test
    public void lockShouldBeBlockedAfterNumberOfFailedAttempts() {
        final int rightTestPin = 1234;
        final int wrongTestPin = 5678;
        final int maxAttempts = this.lock.getMaxAttempts();

        this.lock.setPin(rightTestPin);

        // loop to iterate a number of time that is the lock max attempts + 1, to generate block state
        for (int i = 0; i < maxAttempts + 1; i++){
            this.lock.unlock(wrongTestPin);
        }

        assertTrue(this.lock.isBlocked());
    }

}
