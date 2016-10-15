package com.company.problem.easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @Level Of Difficulty : Low Level
 *
 * @Problem: Rotate elements of array. e.g)  {1,2,3,4,5} -(2 rotation)=> {3,4,5,1,2}
 *
 * @Solution:
 * 1. move elements as the num of rotation from index 0 to tail of array.
 * e.g) length of array=n, rotation: r:
 * elements[0 to r-1] => elements[ n-r to n]
 * and drag all of other elements is dragged forward. [0 to n-r-1]
 */
public class LeftRotation {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] arr1 = new int[k];
        int[] arr2 = new int[n-k];
        int[] newArray = new  int[n];
        arr1 = Arrays.copyOfRange(a,0,k);
        arr2 = Arrays.copyOfRange(a, k,n);

        for (int i =0; i < n-k; i++){
            newArray[i]= arr2[i];
        }

        for (int j = n-k; j<n; j++){
            newArray[j]= arr1[j-arr2.length];
        }
        return newArray;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
