package com.urartusoftware.algorithms;

public class InsertionSort {

    public void printSorted(int[] arr) {

        for (int firstUnsrtdInd = 1; firstUnsrtdInd < arr.length; firstUnsrtdInd++) {
            int element = arr[firstUnsrtdInd];
            int i;

            for (i = firstUnsrtdInd; i > 0 && arr[i - 1] > element; i--) {
                arr[i] = arr[i - 1];
            }

            arr[i] = element;
        }
    }
}
