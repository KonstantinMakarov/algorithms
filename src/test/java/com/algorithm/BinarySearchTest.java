package com.algorithm;

import org.apache.commons.lang3.RandomUtils;
import org.openjdk.jmh.annotations.*;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class BinarySearchTest extends AlgorithmsBaseTest {

    final private int wantedElement = 10;
    final private int arrayLength = 100;

    @Test
    public void binarySearchTest() {
        // algorithm complexity - O(logN)
        int[] array = generateArray(arrayLength);
        Arrays.sort(array);

        BinarySearch binarySearch = new BinarySearch();

        if (binarySearch.findElement(array, wantedElement) != -1) {
            System.out.println("Wanted element <" + wantedElement + "> has been found");
        } else {
            System.out.println("Wanted element <" + wantedElement + "> is absent");
        }

    }

    @Test
    public void simpleSearchTest() {
        // algorithm complexity - O(N)
        int[] array = generateArray(arrayLength);
        Arrays.sort(array);

        boolean wantedElementAbsent = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == wantedElement) {
                System.out.println("Wanted element <" + wantedElement + "> has been found");
                wantedElementAbsent = false;
                break;
            }
        }
        if (wantedElementAbsent){
            System.out.println("Wanted element <" + wantedElement + "> is absent");
        }
    }


    private int[] generateArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = RandomUtils.nextInt();
        }
        return array;
    }

}
