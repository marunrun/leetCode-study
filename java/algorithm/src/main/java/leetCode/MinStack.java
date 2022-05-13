package main.java.leetCode;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class MinStack {

//    ArrayList<Integer> items;
//    int count;
//    int min;
//
//    /**
//     * initialize your data structure here.
//     */
//    public MinStack() {
//        this.items = new ArrayList<>();
//        this.count = 0;
//        this.min = Integer.MAX_VALUE;
//    }
//
//    public void push(int x) {
//        items.add(x);
//        count++;
//        min = Math.min(x, min);
//    }
//
//    public void pop() {
//        if (count == 0) return;
//        count--;
//        Integer removed = items.remove(count);
//        if (removed == min ) {
//            if (items.isEmpty()) {
//                min = Integer.MAX_VALUE;
//            }else {
//                min = items.stream().min(Integer::compareTo).get();
//            }
//        }
//    }
//
//    public int top() {
//        return items.get(count - 1);
//    }
//
//    public int getMin() {
//        return min;
//    }

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.xStack = new LinkedList<>();
        this.minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return xStack.peek();
    }
}
