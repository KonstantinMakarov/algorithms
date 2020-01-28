package com.algorithm;

import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.SECONDS)
public class SortAlgorithmTest extends AlgorithmsBaseTest {

    @Test
    public void testBubbleSort() {
        int[] array = IntInterval.oneTo(10).toReversed().toArray();
        print(array, "Unsorted array:");
        int[] sortedArray = BubbleSort.sort(array);
        print(sortedArray, "Sorted array:");
    }

    @Test
    public void testInsertionSort() {
        int[] array = IntInterval.oneTo(10).toReversed().toArray();
        print(array, "Unsorted array:");
        int[] sortedArray = InsertionSort.sort(array);
        print(sortedArray, "Sorted array:");
    }

    @Test
    public void testSelectionSort() {
        int[] array = IntInterval.oneTo(10).toReversed().toArray();
        print(array, "Unsorted array:");
        int[] sortedArray = SelectionSort.sort(array);
        print(sortedArray, "Sorted array:");
    }

    @Test
    public void testCountingSort() {
        int[] array = IntInterval.oneTo(10).toReversed().toArray();
        print(array, "Unsorted array:");
        int[] sortedArray = CountingSort.sort(array);
        print(sortedArray, "Sorted array:");
    }

    @Test
    public void testMergeSort() {
        int[] array = IntInterval.oneTo(10).toReversed().toArray();
        print(array, "Unsorted array:");
        int[] sortedArray = MergeSort.sort(array);
        print(sortedArray, "Sorted array:");
    }

    @Benchmark
    public int[] test100_bubbleSort() {
        return BubbleSort.sort(IntInterval.oneTo(100).toReversed().toArray());
    }

    @Benchmark
    public int[] test70000_bubbleSort() {
        return BubbleSort.sort(IntInterval.oneTo(70000).toReversed().toArray());
    }

    @Benchmark
    public int[] test100_insertionSort() {
        return InsertionSort.sort(IntInterval.oneTo(100).toReversed().toArray());
    }

    @Benchmark
    public int[] test70000_insertionSort() {
        return InsertionSort.sort(IntInterval.oneTo(70000).toReversed().toArray());
    }

    @Benchmark
    public int[] test100_selectionSort() {
        return SelectionSort.sort(IntInterval.oneTo(100).toReversed().toArray());
    }

    @Benchmark
    public int[] test70000_selectionSort() {
        return SelectionSort.sort(IntInterval.oneTo(70000).toReversed().toArray());
    }

    @Benchmark
    public int[] test100_countingSort() {
        return SelectionSort.sort(IntInterval.oneTo(100).toReversed().toArray());
    }

    @Benchmark
    public int[] test70000_countingSort() {
        return SelectionSort.sort(IntInterval.oneTo(70000).toReversed().toArray());
    }

    @Test
    public void sortingAlgorithmsComparingDemo() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SortAlgorithmTest.class.getSimpleName())
                .warmupIterations(10)
                .measurementIterations(10)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
