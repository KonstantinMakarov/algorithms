package com.algorithm.sort;

public class MergeSort {

    /**
     * Merge sort divides input array in two halves, calls itself for the two halves and then merges the two sorted halves.
     * <p>
     * Algorithm complexity - O(N*logN)
     * <p>
     * https://www.geeksforgeeks.org/merge-sort/
     *
     * @param array int[]
     * @return int[]
     */
    public static int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;

            sort(array, leftIndex, midIndex);
            sort(array, midIndex + 1, rightIndex);

            merge(array, leftIndex, midIndex, rightIndex);
        }
    }

    private static void merge(int[] array, int leftIndex, int midIndex, int rightIndex) {
        int leftArraySize = midIndex - leftIndex + 1;
        int rightArraySize = rightIndex - midIndex;

        int[] tempLeftArray = new int[leftArraySize];
        int[] tempRightArray = new int[rightArraySize];

        //Copy data to temp arrays
        System.arraycopy(array, leftIndex, tempLeftArray, 0, leftArraySize);
        for (int j = 0; j < rightArraySize; j++) {
            tempRightArray[j] = array[midIndex + 1 + j];
        }

        int i = 0, j = 0;
        int k = leftIndex;
        while (i < tempLeftArray.length && j < tempRightArray.length) {
            if (tempLeftArray[i] < tempRightArray[i]) {
                array[k] = tempLeftArray[i];
                i++;
            } else {
                array[k] = tempRightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray/rightArray if any
        while (i < leftArraySize) {
            array[k] = tempLeftArray[i];
            i++;
            k++;
        }
        while (j < rightArraySize) {
            array[k] = tempRightArray[j];
            j++;
            k++;
        }
    }

}
