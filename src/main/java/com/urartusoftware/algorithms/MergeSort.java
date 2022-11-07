package com.urartusoftware.algorithms;

// Splits and merges arrays
// Usually is achieved using recursion
public class MergeSort {

    public int[] mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return null;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }

        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);

        return inputArray;
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int leftIndex = 0, rightIndex = 0, mainIndex = 0;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
                inputArray[mainIndex] = leftHalf[leftIndex];
                leftIndex++;
            } else {
                inputArray[mainIndex] = rightHalf[rightIndex];
                rightIndex++;
            }
            mainIndex++;
        }

        while (leftIndex < leftSize) {
            inputArray[mainIndex] = leftHalf[leftIndex];
            leftIndex++;
            mainIndex++;
        }

        while (rightIndex < rightSize) {
            inputArray[mainIndex] = rightHalf[rightIndex];
            rightIndex++;
            mainIndex++;
        }
    }
}
