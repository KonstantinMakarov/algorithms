package com.algorithm;

import java.util.Arrays;

public class CountingSort {

    /**
     * Counting sort, as opposed to most classic sorting algorithms, does not sort the given input by comparing the elements.
     * Instead it works by counting the number of objects having particular values. Then doing some arithmetic
     * to calculate the position of each object in the output sequence.
     * <p>
     * Algorithm complexity - O(N)
     * <p>
     * https://www.baeldung.com/java-counting-sort
     *
     * @param sourceArray int[]
     * @return int[]
     */
    public static int[] sort(int[] sourceArray) {
        int arrayMaxValue = Arrays.stream(sourceArray).max().orElse(-1);

        //create array with size which is equal to array's maximum element value
        //plus +1 as a compensation for java counting from 0
        int[] countingArray = new int[arrayMaxValue + 1];
        Arrays.fill(countingArray, 0);

        //count number of particular values in array
        for (int sourceArrayValue : sourceArray) {
            countingArray[sourceArrayValue]++;
        }
        // calculate position index for each value
        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] += countingArray[i - 1];
        }
        // decrement to compensate java counting form 0
        for (int i = 0; i < countingArray.length; i++) {
            countingArray[i]--;
        }

        int[] outputArray = new int[sourceArray.length];
        for (int i = sourceArray.length-1; i >= 0; i--) {
            int sourceIndexValue = sourceArray[i];
            int outputIndex = countingArray[sourceIndexValue];
            outputArray[outputIndex] = sourceIndexValue;

            countingArray[sourceIndexValue]--;
        }

        return outputArray;
    }
}
