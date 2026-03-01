package it.unibo.pps.tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  <br>
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  <br>
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Pushes an integer onto the queue.
     *
     * @param value The integer to push into the queue.
     */
    void push(int value);

    /**
     * Pushes an integer onto the queue.
     *
     * @throws IllegalStateException if the queue is empty.
     */
    void remove();

    /**
     * Get the max queue size.
     *
     * @return integer value.
     */
    int maxCapacity();

    /**
     * Retrieves, but does not remove, the top element of the stack.
     *
     * @return The top element of the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    int peek();

}