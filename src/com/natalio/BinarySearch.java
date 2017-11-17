package com.natalio;

public class BinarySearch<T extends Comparable<T>> {
    public T binarySearch(T toFind, T[] arr){
        int high = arr.length;
        int low = 0;
        int mid;

        while (low <= high){
            mid = (high+low) / 2;

            if(toFind.compareTo(arr[mid]) < 0){
                high = mid - 1;
            }
            else if(toFind.compareTo(arr[mid]) > 0){
                low = mid + 1;
            }
            else{
                return arr[mid];
            }
        }
        return null;
    }
}
