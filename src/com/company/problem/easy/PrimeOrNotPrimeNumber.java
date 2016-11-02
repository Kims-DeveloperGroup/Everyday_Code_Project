package com.company.problem.easy;

import java.util.Scanner;

/**
 * @Level Of Difficulty : Low Level
 *
 * @Problem: Find out whether a given number is a prime number or not. Prime numbers are divided only by 1 or themselves.
 *
 * @Solution: Check if '(number%divisor)' is zero by computing from 2 to (number-1) O(n)
 * @Optimization: //
 */
public class PrimeOrNotPrimeNumber {

    public static void isPrime(int num){
        if (num<=3) System.out.println(num+ " is a prime number");
        for (int  divisor =2; divisor<num ; divisor++){

            if (num % divisor ==0 ){
                System.out.println(num+ " is NOT a prime number");
                return;
            }
        }
        System.out.println(num+ " is a prime number");
    }

    public static void isPrime_Optimized(int num){
       //
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int i = 0; i < p; i++){
            int n = in.nextInt();
            isPrime(n);
        }
    }
}
