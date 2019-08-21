package com.juanpabloprado.ds.queue;

import java.util.Arrays;

public class IntArrayQueue {

    /** The capacity of this queue */
    private int capacity;

    /** The queued items */
    private long[] items;

    /** items index for the element in the front */
    private int front;

    /** items index for the element at the back of the line */
    private int rear;

    /** Number of elements in the queue */
    int count;

    public IntArrayQueue(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.capacity = capacity;
        items = new long[capacity];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void add(long e) {

        if(rear == capacity - 1) {
            throw new IllegalStateException("Queue full");
            // rear = -1; // Comment line above and uncomment for circular queue
        }

        rear++;
        items[rear] = e;
        count++;
    }

    public long remove() {
        long temp = items[front];
        if(++front == capacity) {
            // we can set front back to the 0th index so that we can utilize the entire array again
            front = 0;
        }
        count--;
        return temp;
    }

    public long peek() {
        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
