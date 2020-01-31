package com.algorithm.sort;

public class BubbleSort {

    /**
     * Bubble sorting repeatedly steps through the list, compares elements and swaps them if they are in the wrong order.
     * <p>
     * Algorithm complexity - O(N^2)
     * <p>
     * https://www.geeksforgeeks.org/bubble-sort/
     *
     * @param array int[]
     * @return int[]
     */
    public static int[] sort(int[] array) {
        boolean isZeroSwaps = true;
        for (int j = 0; j < array.length-1; j++) {
            for (int i = 0; i < array.length - 1 - j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isZeroSwaps = false;
                }
            }

            if (isZeroSwaps) {
                break;
            }
        }
        return array;
    }

}
