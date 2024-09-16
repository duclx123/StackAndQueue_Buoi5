package Queue;

import Stack.MyStack;

public class MyQueue {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int length;

    public MyQueue() {
        front = null;
        rear = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        // TH1 : Queue Null => front noi node dau tien
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    // dequeue(): remove front element and return data of removed element
// BTVN 1: 2 , 19 -> LeetCode
// BTVN 2: Implement Stack and Queue
    public int dequeue() {
        try {
            int value = this.front.data;
            this.front = this.front.next;
            return value;
        } catch (NullPointerException e) {
            throw new RuntimeException("Queue is empty");
        }
    }
    public void print() {
        Node current = front;
        if (current == null) {
            System.out.println("Queue is empty.");
            return;
        }
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" --> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(4);
        System.out.println("Queue Length: " + queue.getLength());//5
        queue.print();//5 --> 7 --> 3 --> 1 --> 4
        queue.dequeue();
        queue.print();//7 --> 3 --> 1 --> 4
    }

}
