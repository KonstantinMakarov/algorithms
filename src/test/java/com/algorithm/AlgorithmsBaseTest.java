package com.algorithm;

public abstract class AlgorithmsBaseTest {

    public void print(int[] array, String message) {
        System.out.println(message);
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(" <");
            stringBuilder.append(array[i]);
            stringBuilder.append("> ");
        }
        System.out.println(stringBuilder.toString() + "]");
    }
}
