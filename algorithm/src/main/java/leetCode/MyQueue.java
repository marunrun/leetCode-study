package main.java.leetCode;

import java.util.Deque;
import java.util.LinkedList;

class MyQueue {

    Deque<Integer> inQueue;
    Deque<Integer> outQueue;


    /** Initialize your data structure here. */
    public MyQueue() {
        this.inQueue = new LinkedList<Integer>();
        this.outQueue = new LinkedList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inQueue.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        resetOutQueue();
        return outQueue.pop();
    }

    /** Get the front element. */
    public int peek() {
        resetOutQueue();
        return outQueue.peek();
    }

    private void resetOutQueue()
    {
        if (!inQueue.isEmpty() && outQueue.isEmpty()) {
            int size = inQueue.size();
            for (int i = 0; i < size; i++) {
                outQueue.push(inQueue.pop());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }
}