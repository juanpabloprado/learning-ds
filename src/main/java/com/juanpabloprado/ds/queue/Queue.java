package com.juanpabloprado.ds.queue;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A simple queue implementation with a Doubly-linked list
 *
 */
public class Queue<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();

    public Queue() {
    }

    public Queue(T firstElem) {
        offer(firstElem);
    }

    // Return the size of the queue
    public int size() {
        return list.size();
    }

    // Returns whether or not the queue is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Peek the element at the front of the queue
    // The method throws an error is the queue is empty
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue Empty");
        return list.peekFirst();
    }

    // Poll an element from the front of the queue
    // The method throws an error is the queue is empty
    public T poll() {
        if (isEmpty()) throw new IllegalStateException("Queue Empty");
        return list.removeFirst();
    }

    // Add an element to the back of the queue
    public void offer(T elem) {
        list.addLast(elem);
    }

    // Return an iterator to alow the user to traverse
    // through the elements found inside the queue
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
