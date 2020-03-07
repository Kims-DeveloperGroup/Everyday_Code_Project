package com.company.problem.easy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @Level Of Difficulty : Low Level
 *
 * @Problem: Compute the Fibonacci number of a given level.
 *
 * @Solution: Simply add a fib number of 'n-1' and 'n-2'.  O(2^n)
 * @Optimization: With a cache, computation is largely reduced by simply returning a cached fibonacci number. O(n)
 */
public class Fibonacci {


    public static int fibonacci(int n, AtomicInteger count) {
        if (n <=1) return n;
        count.incrementAndGet();
        return fibonacci(n-1,count)+fibonacci(n-2, count);
    }

    public static int fibonacciWithCache(int n, int[] cache, AtomicInteger count) {
        if (n <=1) return n;
        if (cache[n]==-1){
            cache[n]= fibonacciWithCache(n-1, cache, count)+fibonacciWithCache(n-2, cache, count);
            count.incrementAndGet();
        }
        return cache[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        AtomicInteger count1= new AtomicInteger(0);
        AtomicInteger count2= new AtomicInteger(0);
        System.out.println("Fibonacci: "+ fibonacci(n,count1));
        System.out.println("Count: "+ count1);
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        System.out.println("Fibonacci with Cache: "+fibonacciWithCache(n,cache, count2));
        System.out.println("Count: "+ count2);
        scanner.close();

    }
}
