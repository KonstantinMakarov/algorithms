package com.algorithm;

public class InsertionSort {

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (currentValue < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[i + 1] = currentValue;
        }
        return array;
    }
}
