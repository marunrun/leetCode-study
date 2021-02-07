package main.java.algorithm;

public class CircularQueue {

    private String[] items;

    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public CircularQueue(int n) {
        items = new String[n];
        this.n = n;
    }

    public boolean enqueue(String item) {
        if ((tail +1)%n ==head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }


    public String dequeue(){
        if (head == tail) return null;
        String res = items[head];
        head = (head + 1) % n ;
        return res;
    }
}
