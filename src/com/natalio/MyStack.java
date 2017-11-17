package com.natalio;

public class MyStack<T> {

    private class Node{
        private T value;
        private Node next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private int numElements;

    public void push(T value){
        Node aNode = new Node(value);
        aNode.next = head;
        head = aNode;
        numElements++;
    }

    public T pop() {
        if(isEmpty()){
            return null;
        }

        T toPop = head.value;
        head = head.next;
        numElements--;

        return toPop;
    }

    public boolean isEmpty(){
        return numElements == 0;
    }

    public static void main(String args[]){
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(2);
        myStack.push(4);
        myStack.push(6);
        myStack.push(8);

        while (!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }
    }
}

