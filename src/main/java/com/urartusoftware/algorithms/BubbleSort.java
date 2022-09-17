package com.urartusoftware.algorithms;

import java.util.Arrays;

public class BubbleSort {

    // Optimized way
    public void printSorted(int[] arr) {

        for (int endUnsrtdIdx = arr.length - 1; endUnsrtdIdx > 0; endUnsrtdIdx--) {
            for (int i = 0; i < endUnsrtdIdx; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
