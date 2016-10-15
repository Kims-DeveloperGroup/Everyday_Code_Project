package com.company.sample;

import java.util.Arrays;

/**
 * Created by devoo-kim on 16. 10. 6.
 */
public class ArrayRelatedSample {
    public static void main(String[] args){
//        fillArray();
//        fill2dArray();
        sortArray();


    }//

    public static void basicOfArray(){
        int[][] arr1 = new int[4][7];
        int[][] arr2 = new int[4][];
        System.out.printf("Array1 length is %d \n", arr1.length);//Return size of Y
        System.out.printf("Array2 length is %d \n", arr2.length);//Return size of Y
        System.out.printf("Array1 [0] length is %d \n", arr1[0].length);//OK
        System.out.printf("Array2 length is %d \n", arr2[0].length);//NullPointerException
    }

    public  static void copyArray1(){
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd' };
        char[] copyTo = new char[7];
        /**
         * System.arraycopy
         * @param1 : Source array
         * @param2 : Start position of source
         * @param3 : Destination Array
         * @param4 : Start positon of Destination
         * @param5 : Number of elements to copy
         * **/
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));
    }
    public static void copyArray2(){
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9); //Third param is exclusive index

        System.out.println(new String(copyTo));
    }

    public static void fillArray(){
        char[] msg = new char[10];
        Arrays.fill(msg, 'a');
        for(char ch: msg){
            System.out.println(ch);
        }
    }
    public static void fill2dArray(){
        boolean[][] matrix = new boolean[20][4];

        for (boolean[] row: matrix)
            Arrays.fill(row, false);

        for (boolean[] arr : matrix)
            for (boolean el : arr)
                System.out.print(el+" ");
    }

    public static void sortArray(){
        int[] unsorted_num ={5,5,7,6,1,2,8,4,2,3};
        System.out.println("Unsorted Array: ");
        for (int num: unsorted_num)
            System.out.print(num+", ");
        Arrays.sort(unsorted_num);
        System.out.println();
        for (int num: unsorted_num)
            System.out.print(num+", ");
    }

    /** Usage Tip of java.util.Arrays class
     * 1.Searching an array for a specific data to get the index at which it is placed (the binarySearch method).
     * 2. Comparing two arrays to determine if they are equal or not (the equals method).
     * 3. Filling an array to place a specific data at each index (the fill method).
     * 4.Sorting an array into ascending order. This can be done either sequentially,
     * using the sort method, or concurrently, using the parallelSort method introduced in Java SE 8.
     *
     */
}
