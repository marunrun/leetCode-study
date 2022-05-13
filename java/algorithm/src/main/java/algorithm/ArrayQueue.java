package main.java.algorithm;

public class ArrayQueue {
    private String[] items;
    private int n = 0;

    // 队头
    private int head = 0;
    // 队尾
    private int tail = 0;

    public ArrayQueue(int n) {
        items = new String[n];
        this.n = n;
    }

    public boolean enqueue(String item) {
        // 队列已满
        if (tail == n) {
            if (head == 0) return false;

            for (int i = head; i < n; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue() {
        // 队列为空
        if (head == tail) return null;
        String res = items[head];
        ++head;
        return res;
    }

}
