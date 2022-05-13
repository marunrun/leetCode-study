package main.java.leetCode;

public class LeetCode232 {

    /**
     * ["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
     * [[],[1],[2],[3],[4],[],[5],[],[],[],[]]
     * @param args
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(3); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(4); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        myQueue.push(5); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.pop()); // return 1, queue is [2]
    }
}
