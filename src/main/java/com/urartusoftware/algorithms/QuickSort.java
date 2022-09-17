package com.urartusoftware.algorithms;

// Recursive
public class QuickSort {

    public void getSorted(int[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }

//        int pivotIndex = partition(arr, start, end);
//        getSorted(arr, start, pivotIndex);
//        getSorted(arr, pivotIndex + 1, end);
    }

//    public int partition(int[] arr, int start, int end) {
//        int pivot = arr[start];
//        int i = start;
//        int j = end;
//
//        while (i < j) {
//                while (i < j && arr[--j] >= pivot);
//        }
//
//    }
}
