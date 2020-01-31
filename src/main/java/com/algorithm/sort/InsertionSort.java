package com.algorithm.sort;

public class InsertionSort {

    /**
     * Sorting algorithm that works the way we sort playing cards in our hands.
     * <p>
     * Algorithm complexity - O(N^2)
     * <p>
     * https://www.geeksforgeeks.org/insertion-sort/
     *
     * @param array int[]
     * @return int[]
     */
    public static int[] sort(int[] array) {
        for (int globalIndex = 1; globalIndex < array.length; globalIndex++) {
            int globalIndexValue = array[globalIndex];
            int localIndex;
            for (localIndex = globalIndex - 1; localIndex >= 0; localIndex--) {
                if (globalIndexValue < array[localIndex]) {
                    array[localIndex + 1] = array[localIndex];
                } else {
                    break;
                }
            }
            array[localIndex + 1] = globalIndexValue;
        }
        return array;
    }
}
