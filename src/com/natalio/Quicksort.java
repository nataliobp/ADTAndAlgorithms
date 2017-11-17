package com.natalio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Quicksort {
    public static void main(String args[]){
        ArrayList<Integer> myData = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        Collections.shuffle(myData);
        int[] data = new int[myData.size()];
        for(int i = 0; i < data.length; i++){
            data[i] = myData.get(i);
        }
        int[] result = quicksort(data, 0, data.length-1);

        System.out.println(Arrays.toString(result));

    }

    private static int[] quicksort(int[] data, int lo, int hi){
        if(hi <= lo){
            return data;
        }

        int i,wall;

        for(i = lo, wall = lo; i < hi; i++){
            if(data[i] < data[hi]){
                swap(i, wall, data);
                wall++;
            }
        }

        swap(hi, wall, data);

        quicksort(data, lo, wall-1);
        quicksort(data, wall, hi);

        return data;
    }

    private static void swap(int i, int wall, int[] data) {
        int aux = data[i];
        data[i] = data[wall];
        data[wall] = aux;
    }
}
