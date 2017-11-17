package com.natalio;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E>{

    private LLNode<E> tail;
    private LLNode<E> head;
    private int size = 0;
    
    public MyLinkedList(){
        head = new LLNode<>();
        tail = new LLNode<>();
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        for(
                LLNode<E> currentNode = head.next;
                currentNode != tail;
                currentNode = currentNode.next
        ){
            if(currentNode.data.equals(o)){
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];

        int i = 0;

        for(
                LLNode<E> currentNode = head.next;
                currentNode != tail;
                currentNode = currentNode.next
        ){
            result[i] = currentNode.data;
            i++;
        }

        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(E o) {
        LLNode<E> myNode = new LLNode(o);

        tail.prev.next = myNode;
        myNode.prev = tail.prev;

        myNode.next = tail;
        tail.prev = myNode;

        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {

        for(
                LLNode<E> currentNode = head.next;
                currentNode != tail;
                currentNode = currentNode.next
        ){
            if(currentNode.data.equals(o)){
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void clear() {
        head = new LLNode(null);
        tail = new LLNode(null);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public E get(int i) {
        LLNode<E> currentNode = getNodeOfIndex(i);

        if(currentNode == null){
            return null;
        }

        return currentNode.data;
    }

    @Override
    public E set(int i, E o) {
        LLNode<E> currentNode = getNodeOfIndex(i);

        if(currentNode == null){
            return null;
        }

        currentNode.data = o;

        return currentNode.data;
    }

    @Override
    public void add(int i, E o) {
        LLNode<E> currentNode = getNodeOfIndex(i);

        if(currentNode != null){
            LLNode<E> myNode = new LLNode<>(o);
            myNode.next = currentNode.next;
            myNode.prev = currentNode;

            currentNode.next.prev = myNode;
            currentNode.next = myNode;
        }
    }

    @Override
    public E remove(int i) {
        int j = 0;
        LLNode<E> currentNode = head.next;

        while(currentNode != tail && j < i){
            currentNode = currentNode.next;
            j++;
        }

        if(i == j){
            remove(currentNode);
            return currentNode.data;
        }

        return null;
    }

    private LLNode<E> getNodeOfIndex(int i) {
        int j;
        LLNode<E> currentNode = head.next;

        for(j=0; currentNode != tail && j < i; j++){
            currentNode = currentNode.next;
        }

        if(i != j){
            return null;
        }

        return currentNode;
    }

    @Override
    public int indexOf(Object o) {
        LLNode<E> currentNode = head.next;

        for(int i = 0; currentNode != tail; i++, currentNode = currentNode.next){
            if(currentNode.data.equals(o)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        LLNode<E> currentNode = head.next;
        int result = -1;

        for(int i = 0; currentNode != tail; i++, currentNode = currentNode.next){
            if(currentNode.data.equals(o)){
                result = i;
            }
        }

        return result;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return null;
    }

    @Override
    public List<E> subList(int i, int i1) {
        return null;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }
}

class LLNode<E> {
    LLNode<E> prev = null;
    LLNode<E> next = null;
    E data;

    LLNode(){
        data = null;
    }

    LLNode(E s){
        data = s;
    }
}