package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLockImpl lock;
    private final int TEST_PIN_VALID = 1234;

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
        assertThrows(IllegalStateException.class, () -> this.lock.unlock(TEST_PIN_VALID));
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
        final int testPin2 = 4567;

        this.lock.setPin(TEST_PIN_VALID);
        assertThrows(IllegalStateException.class, () -> this.lock.setPin(testPin2));
    }

    @Test
    public void lockShouldBeLockedIfPinIsSet() {
        this.lock.setPin(TEST_PIN_VALID);
        assertTrue(this.lock.isLocked());
    }

    @Test
    public void lockShouldBeRemainLockedIfUnlockPinIsWrong() {
        final int wrongTestPin = 5678;

        this.lock.setPin(TEST_PIN_VALID);
        this.lock.unlock(wrongTestPin);
        assertTrue(this.lock.isLocked());
    }

    @Test
    public void lockShouldBeUnlocked() {
        this.lock.setPin(TEST_PIN_VALID);
        this.lock.unlock(TEST_PIN_VALID);
        assertFalse(this.lock.isLocked());
    }

    @Test
    public void lockCannotBeLockedIfAlreadyLocked() {
        this.lock.setPin(TEST_PIN_VALID);
        assertThrows(IllegalStateException.class, () -> this.lock.lock());
    }

    @Test
    public void lockCannotBeUnlockedIfAlreadyUnlocked() {
        this.lock.setPin(TEST_PIN_VALID);
        this.lock.unlock(TEST_PIN_VALID);
        assertThrows(IllegalStateException.class, () -> this.lock.unlock(TEST_PIN_VALID));
    }

    @Test
    public void lockShouldBeLockedAfterSetAndUnlock() {
        this.lock.setPin(TEST_PIN_VALID);
        this.lock.unlock(TEST_PIN_VALID);
        this.lock.lock();
        assertTrue(this.lock.isLocked());
    }

    @Test
    public void failedAttemptsShouldIncreaseOnUnlockFail() {
        final int wrongTestPin = 5678;
        final int failedAttempts = this.lock.getFailedAttempts();

        this.lock.setPin(TEST_PIN_VALID);
        this.lock.unlock(wrongTestPin);
        assertTrue(this.lock.getFailedAttempts() > failedAttempts);
    }

    @Test
    public void lockShouldBeBlockedAfterNumberOfFailedAttempts() {
        final int wrongTestPin = 5678;
        final int maxAttempts = this.lock.getMaxAttempts();

        this.lock.setPin(TEST_PIN_VALID);

        // loop to iterate a number of time that is the lock max attempts + 1, to generate block state
        for (int i = 0; i < maxAttempts + 1; i++){
            this.lock.unlock(wrongTestPin);
        }

        assertTrue(this.lock.isBlocked());
    }

    @Test
    public void unlockNotPermittedIfLockIsLocked() {
        final int wrongTestPin = 5678;
        final int maxAttempts = this.lock.getMaxAttempts();

        this.lock.setPin(TEST_PIN_VALID);

        // loop to iterate a number of time that is the lock max attempts + 1, to generate block state
        for (int i = 0; i < maxAttempts + 1; i++){
            this.lock.unlock(wrongTestPin);
        }

        assertThrows(IllegalStateException.class, () -> this.lock.unlock(TEST_PIN_VALID));
    }

    @Test
    public void lockShouldReset() {
        final int wrongTestPin = 5678;
        final int maxAttempts = this.lock.getMaxAttempts();
        final int initialFailedAttempts = this.lock.getFailedAttempts();

        this.lock.setPin(TEST_PIN_VALID);

        // loop to iterate a number of time that is the lock max attempts + 1, to generate block state
        for (int i = 0; i < maxAttempts + 1; i++){
            this.lock.unlock(wrongTestPin);
        }

        this.lock.reset();

        assertFalse(this.lock.isLocked());
        assertFalse(this.lock.isBlocked());
        assertEquals(initialFailedAttempts, this.lock.getFailedAttempts());
        assertTrue(this.lock.isDefaultPinSet());

    }

}
