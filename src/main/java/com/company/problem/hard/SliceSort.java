package com.company.problem.hard;

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

    public int sort(int[] array) {
        int count = array.length;
        return count;
    }
}
