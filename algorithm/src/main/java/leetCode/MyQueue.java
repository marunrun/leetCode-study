package main.java.leetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class MyQueue {

    Stack<Integer> inQueue;
    Stack<Integer> outQueue;


    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.inQueue = new Stack<>();
        this.outQueue = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inQueue.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outQueue.isEmpty()) {
            resetOutQueue();
        }
        return outQueue.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outQueue.isEmpty()) {
            resetOutQueue();
        }
        return outQueue.peek();
    }

    private void resetOutQueue() {
        while (!inQueue.isEmpty()) {
            outQueue.push(inQueue.pop());
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }
}