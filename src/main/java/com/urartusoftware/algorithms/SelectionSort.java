package com.urartusoftware.algorithms;

import java.util.Arrays;

public class SelectionSort {

    public void printSorted(int[] arr) {

        for (int endUnsrtdInd = arr.length - 1; endUnsrtdInd > 0; endUnsrtdInd--) {
            int indOfLargest = 0;

            for (int i = 1; i <= endUnsrtdInd; i++) {
                if (arr[i] > arr[indOfLargest]) {
                    indOfLargest = i;
                }
            }

            swap(arr, endUnsrtdInd, indOfLargest);
        }

        System.out.println(Arrays.toString(arr));
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
