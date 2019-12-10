package com.algorithm;

import java.util.Arrays;

public class BinarySearch {

    public int findElement(int[] array, int wantedElement) {
        int midNumber = array.length / 2;
        if (midNumber < 1){
            return -1;
        }
        if (array[midNumber] == wantedElement) {
            return array[midNumber];
        } else if (array[midNumber] > wantedElement) {
            return findElement(Arrays.copyOf(array, midNumber), wantedElement);

        } else if (array[midNumber] < wantedElement) {
            return findElement(Arrays.copyOfRange(array, midNumber, array.length), wantedElement);
        }
        throw new IllegalArgumentException();
    }
}
