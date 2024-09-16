package Stack;

import Queue.MyQueue;

import java.util.EmptyStackException;

public class MyStack {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int length;

    public MyStack() {
        top = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        length++;
    }

    // pop(): remove top element and return data of removed element
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void print() {
        MyStack.Node current = top;
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
        MyStack myStack = new MyStack();
        myStack.push(5);
        myStack.push(7);
        myStack.push(9);
        myStack.push(3);
        myStack.push(6);
        myStack.print();//6 --> 3 --> 9 --> 7 --> 5
        System.out.println("Peek : " + myStack.peek());//6
        System.out.println("Pop : " + myStack.pop());//6
        myStack.print();//3 --> 9 --> 7 --> 5
    }
}
