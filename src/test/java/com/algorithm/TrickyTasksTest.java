package com.algorithm;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TrickyTasksTest {

    // Найти два числа в отсортированном массиве A, которые в сумме дают S
    @Test
    public void testFindTwoNumber_quickest() {
        int[] array = {-1, 3, 4, 5, 5, 6, 11, 17, 45};

        int sum = 10;

        Map<Integer, Integer> temp = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            Integer tempIndex = temp.get(array[i]);
            if (tempIndex != null) {
                System.out.println(array[tempIndex] + " and " + array[i]);
            }

            int tempValue = sum - array[i];
            temp.put(tempValue, i);
        }
    }

    @Test
    public void testFindTwoNumber_bruteForce() {
        int[] array = {-1, 3, 4, 5, 5, 6, 11, 17, 45};

        int sum = 10;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    System.out.println(array[i] + " and " + array[j]);
                }
            }
        }
    }

    @Test
    public void testFindTwoNumber_custom() {
        int[] array = {1, 3, 4, 5, 5, 6, 17, 45};

        int sum = 10;



        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    System.out.println(array[i] + " and " + array[j]);
                }
            }
        }
    }
}
