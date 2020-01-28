package com.algorithm;

public class BinarySearch {

    /**
     * The binary search based on the search in the balanced binary tree.
     * Source array should be sorted by default.
     * <p>
     * Algorithm complexity - O(logN)
     */
    public static int binaryRecursiveSearch(int[] array, int leftIndex, int rightIndex, int wantedElement) {
        if (rightIndex >= leftIndex) {
            int localRange = rightIndex - leftIndex; //from 0 to last index in localRange
            int midIndexInLocalRange = localRange / 2;
            int midIndexInGlobalRange = leftIndex + midIndexInLocalRange;

            // If element is bigger than mid, then it can only be present in right subarray
            if (wantedElement > array[midIndexInGlobalRange]) {
                return binaryRecursiveSearch(array, midIndexInGlobalRange + 1, rightIndex, wantedElement);
            }

            // If element is smaller than mid, then it can only be present in left subarray
            if (wantedElement < array[midIndexInGlobalRange]) {
                return binaryRecursiveSearch(array, leftIndex, midIndexInGlobalRange - 1, wantedElement);
            }

            // Else the element can only be present at the middle itself
            return midIndexInGlobalRange;
        }

        // We reach here when element is not present in array
        return -1;
    }

    public static int binarySearchWhile(int[] array, int leftIndex, int rightIndex, int wantedElement) {

        while (leftIndex <= rightIndex) {
            int localRange = rightIndex - leftIndex;
            int midIndexInLocalRange = localRange / 2;
            int midIndexInGlobalRange = leftIndex + midIndexInLocalRange;

            if (wantedElement > array[midIndexInGlobalRange]) {
                leftIndex = midIndexInGlobalRange + 1;
            } else if (wantedElement < array[midIndexInGlobalRange]) {
                rightIndex = midIndexInGlobalRange - 1;
            } else {
                return midIndexInGlobalRange;
            }

        }

        return -1;
    }
}
