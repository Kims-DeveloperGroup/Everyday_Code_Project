package com.company.problem.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * PROBLEM:
 *
 * We are given an array A consisting of N distinct integers.
 * We would like to sort array A into ascending order using a simple algorithm.
 * First, we divide it into one or more slices (a slice is a contiguous subarray).
 * Then we sort each slice. After that, we join the sorted slices in the same order.
 * Write a function solution that returns the maximum number of slices for which the algorithm will return a correctly sorted array.
 *
 * 1. Given A = [2,4,1,6,5,9,7] will return e.
 * [2,4,1], [6,5], [9,7] then after soring each slice and joining them together, the whole array will be sorted into ascending order.
 *
 * A= [4,3,2,6,1] will return 1. the array cannot be split into smaller slices; it has to be sorted all at once.
 *
 *
 * 3. A = [2,1,6,4,3,7] will return 3.
 *
 * N range [1..100,000]
 * element range [1..1,000,000,000]
 */
public class SliceSort {

    public int sort(Integer[] array) {
        int count = 0;
        // Exit condition 1 : array length is 1
        if (array.length == 1) {
            return 1;
        }
        // 1) Slice until asc order stops (Note: a last element included)
        List<Integer[]> slices = slice(array);

        // Exit condition 2: Only a single slice exits
        if (slices.size() == 1) {
            Arrays.sort(array);
            return 1;
        }
        // 2) Recursive call sort() for each sliced array
        for (Integer[] s: slices) {
            count += sort(s);
        }
        // 3) Merge sliced arrays sequentially and verify elements are asc ordered.
        List<Integer> merged = new LinkedList<>();

        Integer prev = null;
        boolean sorted = true;
        for (Integer[] slice: slices) {

            for (Integer el: slice) {
                merged.add(el);
                if (prev == null) {
                    prev = el;
                    continue;
                }
                if (el < prev) {
                    sorted = false;
                }
            }
        }
        // 4-1) if so, Assign the sorted array to the given array
        // 4-2) otherwise, Re-sort the merged array and slice count is 1
        if (sorted) {
            merged.toArray(array);
        } else {
            count = 1;
            Arrays.sort(array);
        }
        // 5) Return the count of slices
        return count;
    }

    private List<Integer[]> slice(Integer[] array) {
        List<Integer[]> slices = new ArrayList<>();

        Integer prev = null;
        List<Integer> slice = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (prev == null) {
                prev = array[i];
                slice.add(array[i]);
                continue;
            }

            if (array[i] < prev) {
                slice.add(array[i]);

                Integer[] e = slice.toArray(new Integer[]{});
                slices.add(e);
                prev = null;
                slice = new LinkedList<>();
            } else {
                prev = array[i];
                slice.add(array[i]);
                if (i == array.length -1) {
                    slices.add(slice.toArray(new Integer[]{}));
                }
            }
        }
        return slices;
    }
}
