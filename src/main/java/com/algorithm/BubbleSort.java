package com.algorithm;

public class BubbleSort {

    /**
     * Bubble sorting repeatedly steps through the list, compares elements and swaps them if they are in the wrong order.
     * <p>
     * Algorithm complexity - O(N^2)
     *
     * @param array int[]
     * @return int[]
     */
    public static int[] sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length; i++) {
                if (nextIndexIsNotOutOfBound(array, i) && array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }

    private static boolean nextIndexIsNotOutOfBound(int[] array, int iterator) {
        return iterator + 1 < array.length;
    }
}
