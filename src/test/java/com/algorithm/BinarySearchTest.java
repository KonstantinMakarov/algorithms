package com.algorithm;

import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class BinarySearchTest {

    /**
     * The binary search based on the search in the balanced binary tree
     * <p>
     * Algorithm complexity - O(logN)
     */
    public int binarySearch(int[] array, int wantedElement) {

        int midNumber = array.length / 2;

//        System.out.println(midNumber); //Uncomment to see the power of binary search
        if (midNumber < 1) {
            return -1;
        }
        if (array[midNumber] == wantedElement) {
            return array[midNumber];
        } else if (array[midNumber] > wantedElement) {
            return binarySearch(Arrays.copyOf(array, midNumber), wantedElement);

        } else if (array[midNumber] < wantedElement) {
            return binarySearch(Arrays.copyOfRange(array, midNumber, array.length), wantedElement);
        }
        throw new IllegalArgumentException();

    }

    /**
     * Simple search needs to go through the whole array in bad case
     * <p>
     * Algorithm complexity - O(N)
     */
    public int simpleSearch(int[] array, int wantedElement) {

        for (int i = 0; i < array.length; i++) {
//            System.out.println(i); //Uncomment to see the power of binary search
            if (array[i] == wantedElement) {
                return array[i];
            }
        }
        return -1;
    }

    @Benchmark
    public int search100_simple() {
        return simpleSearch(IntInterval.oneTo(100).toArray(), 100);
    }

    @Benchmark
    public int search100_binary() {
        return binarySearch(IntInterval.oneTo(100).toArray(), 100);
    }

    @Benchmark
    public int searchMillion_simple() {
        return simpleSearch(IntInterval.oneTo(1000000).toArray(), 1000000);
    }

    @Benchmark
    public int searchMillion_binary() {
        return binarySearch(IntInterval.oneTo(1000000).toArray(), 1000000);
    }

    @Test
    public void binarySearchVsSimpleSearchDemo() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BinarySearchTest.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(3)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
