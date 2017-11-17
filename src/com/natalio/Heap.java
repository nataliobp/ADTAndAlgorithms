package com.natalio;

public class Heap {
    class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    private Node[] data;
    private int numElements = 0;

    public Heap(int size) {
        data = new Node[size];
    }

    public Heap(int[] unsortedData){
        this(unsortedData.length+1);

        for(int i = 0; i < unsortedData.length; i++){
            insert(new Node(unsortedData[i], i));
        }
    }

    public void insert(Node value){
        data[++numElements] = value;
        swim(numElements);
    }

    public Node delMax(){
        Node value = data[1];
        swap(1, numElements--);
        data[numElements+1] = null;
        sink(1);
        
        return value;
    }

    private void swim(int pos) {
        while ((pos/2 > 0) && (data[pos/2].value > data[pos].value)){
            swap(pos/2, pos);
            pos = pos/2;
        }
    }

    private void sink(int pos) {

        while ((pos*2) <= numElements){
            int childrenPos = pos*2;

            if((childrenPos+1 <= numElements) && (data[childrenPos + 1].value < data[childrenPos].value)){
                childrenPos++;
            }

            if(data[pos].value < data[childrenPos].value){
                break;
            }

            swap(pos, childrenPos);
            pos = childrenPos;
        }
    }

    private void swap(int pos1, int pos2) {
        Node aux = data[pos1];
        data[pos1] = data[pos2];
        data[pos2] = aux;
    }

    public boolean isEmpty(){
        return numElements <= 0;
    }

    public static Node[] sort(int[] arr){
        Node[] result = new Node[arr.length];
        Heap aHeap = new Heap(arr);

        for (int i = 0; !aHeap.isEmpty(); i++){
            result[i] = aHeap.delMax();
        }

        return result;
    }
}
