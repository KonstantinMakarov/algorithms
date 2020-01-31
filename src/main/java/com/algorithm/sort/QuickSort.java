package com.algorithm.sort;

public class QuickSort {

    /**
     * Quick sort choose the pivot and sort left and right arrays around the pivot.
     *
     * <b>NOTE:</b> Without optimization we will have StackOverFlowError in bad case (array is sorted in decreasing order)
     * because of huge number of recursion calls.
     * More info: https://www.geeksforgeeks.org/quicksort-tail-call-optimization-reducing-worst-case-space-log-n/
     *
     * <p>
     * Algorithm complexity - O(N*logN)
     * <p>
     * https://www.geeksforgeeks.org/quick-sort/
     *
     * @param array int[]
     * @return int[]
     */
    public static int[] sort(int[] array) {
        optimizedQuickSort(array, 0, array.length - 1);
        return array;
    }

    //default version will lead to StackOverFlowError in bad case. Because of imbalanced huge number of recursion calls
    @Deprecated
    private static void defualQuickSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivot = partition(array, leftIndex, rightIndex);
            defualQuickSort(array, leftIndex, pivot - 1);
            defualQuickSort(array, pivot + 1, rightIndex);
        }
    }

    private static void optimizedQuickSort(int[] array, int leftIndex, int rightIndex) {
        while (leftIndex < rightIndex) {
            int pivotIndex = partition(array, leftIndex, rightIndex);
            if (pivotIndex - leftIndex < rightIndex - pivotIndex) {
                optimizedQuickSort(array, leftIndex, pivotIndex - 1);
                leftIndex = pivotIndex + 1;
            } else {
                optimizedQuickSort(array, pivotIndex + 1, rightIndex);
                rightIndex = pivotIndex - 1;
            }
        }
    }

    private static int partition(int[] array, int leftIndex, int rightIndex) {
        // we can choose right/left/mid index or random index (method implementation will be changed)
        int pivot = array[rightIndex];
        int lowerIndex = leftIndex - 1;

        for (int j = leftIndex; j < rightIndex; j++) {
            if (array[j] < pivot) {

                lowerIndex++;
                int temp = array[lowerIndex];
                array[lowerIndex] = array[j];
                array[j] = temp;
            }
        }

        //move pivot to the middle between lower and bigger values
        lowerIndex++;
        int temp = array[lowerIndex];
        array[lowerIndex] = pivot; //new pivot location
        array[rightIndex] = temp;

        return lowerIndex;
    }

}
