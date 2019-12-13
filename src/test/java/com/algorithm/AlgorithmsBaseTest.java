package com.algorithm;

public abstract class AlgorithmsBaseTest {

    public void print(int[] array, String message) {
        System.out.println(message);
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int value : array) {
            stringBuilder.append(" <");
            stringBuilder.append(value);
            stringBuilder.append("> ");
        }
        System.out.println(stringBuilder.toString() + "]\n");
    }
}
