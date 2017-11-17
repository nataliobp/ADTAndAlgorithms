package com.natalio;

public class MyQueue<T> {
    private class Node{
        Node next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int numElements;

    public MyQueue() {
    }

    public void enqueue(T value){
        Node aNode = new Node(value);

        if(isEmpty()){
            head = tail = aNode;
        } else{
            tail.next = aNode;
            tail = aNode;
        }

        numElements++;
    }

    public T dequeue(){
        if(isEmpty()){
            return null;
        }

        T aValue = head.value;
        head = head.next;
        numElements--;

        if(isEmpty()){
            tail = null;
        }

        return aValue;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public static void main(String[] args){
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);

        while (!myQueue.isEmpty()){
            System.out.println(myQueue.dequeue());
        }

        myQueue.enqueue(6);

        while (!myQueue.isEmpty()){
            System.out.println(myQueue.dequeue());
        }

    }
}
