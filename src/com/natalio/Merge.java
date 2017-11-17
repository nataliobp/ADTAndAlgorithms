package com.natalio;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args){
        int[] data = {7,5,9,1,3};
        int[] result = sort(data);

        System.out.println(Arrays.toString(result));

    }

    private static int[] sort(int[] data){

        if(data.length == 1){
            return data;
        }

        int median = data.length / 2;

        return merge(
            sort(Arrays.copyOfRange(data, 0, median)),
            sort(Arrays.copyOfRange(data, median, data.length))
        );
    }

    private static int[] merge(int[] first, int[] second) {

        int i = 0, j = 0;
        int[] result = new int[first.length+second.length];

        for (int k = 0; k < result.length; k++){
            if(i == first.length){
                result[k] = second[j++];
            }else if(j == second.length){
                result[k] = first[i++];
            } else if(first[i] < second[j]){
                result[k] = first[i++];
            } else{
                result[k] = second[j++];
            }
        }

        return result;
    }


}
