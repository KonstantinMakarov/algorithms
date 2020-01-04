package com.algorithm;

public class SelectionSort {

    /**
     * Selection sort based on repeatedly finding the minimum element from unsorted part and putting it at the beginning
     * <p>
     * Algorithm complexity - O(N^2)
     * <p>
     * https://www.geeksforgeeks.org/selection-sort/
     *
     * @param array int[]
     * @return int[]
     */
    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //no need to swap if current element is already the minimum
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

}
