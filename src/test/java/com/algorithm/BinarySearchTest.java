package com.algorithm;

import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BinarySearchTest {

    /**
     * Simple search needs to go through the whole array in bad case
     * <p>
     * Algorithm complexity - O(N)
     */
    public int simpleSearch(int[] array, int wantedElement) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == wantedElement) {
                System.out.println("Element found at index " + i);
                return i;
            }
        }
        System.out.println("Element not present");
        return -1;
    }

    public void searchBinaryRecursive(int[] array, int wantedElement){
        int rightIndex = array.length - 1;
        int result = BinarySearch.binaryRecursiveSearch(array, 0, rightIndex, wantedElement);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

    public void searchBinaryWhile(int[] array, int wantedElement){
        int rightIndex = array.length - 1;
        int result = BinarySearch.binarySearchWhile(array, 0, rightIndex, wantedElement);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

    @Benchmark
    public void search100_simple() {
        simpleSearch(IntInterval.oneTo(100).toArray(), 100);
    }

    @Benchmark
    public void search100_binaryRecursive() {
        searchBinaryRecursive(IntInterval.oneTo(100).toArray(), 100);
    }

    @Benchmark
    public void search100_binaryWhile() {
        searchBinaryWhile(IntInterval.oneTo(100).toArray(), 100);
    }

    @Benchmark
    public void searchMillion_simple() {
        simpleSearch(IntInterval.oneTo(1000000).toArray(), 1000000);
    }

    @Benchmark
    public void searchMillion_binaryRecursive() {
        searchBinaryRecursive(IntInterval.oneTo(1000000).toArray(),1000000);
    }

    @Benchmark
    public void searchMillion_binaryWhile() {
        searchBinaryWhile(IntInterval.oneTo(1000000).toArray(), 1000000);
    }

    @Benchmark
    public void search100Million_simple() {
        simpleSearch(IntInterval.oneTo(100000000).toArray(), 100000000);
    }

    @Benchmark
    public void search100Million_binaryRecursive() {
        searchBinaryRecursive(IntInterval.oneTo(100000000).toArray(),100000000);
    }

    @Benchmark
    public void search100Million_binaryWhile() {
        searchBinaryWhile(IntInterval.oneTo(100000000).toArray(), 100000000);
    }

    @Test
    public void binarySearchVsSimpleSearchDemo_performanceAnalysis() {
        int[] array = IntInterval.oneTo(100000000).toArray();
        for (int i=0; i<10; i++) {
            System.out.println(i);
            long start = System.nanoTime();
            searchBinaryRecursive(array, 100000000);
            System.out.println("Binary Recursive: " + (System.nanoTime() - start)/10000);
            start = System.nanoTime();
            simpleSearch(array, 100000000);
            System.out.println("Simple " + (System.nanoTime() - start)/10000);
            start = System.nanoTime();
            searchBinaryWhile(array, 100000000);
            System.out.println("Binary While " + (System.nanoTime() - start)/10000);
        }
    }

    @Test
    public void binarySearchVsSimpleSearchDemo_jmh() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BinarySearchTest.class.getSimpleName())
                .warmupIterations(10)
                .measurementIterations(50)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
