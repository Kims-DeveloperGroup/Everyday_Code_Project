package com.company.problem.intermediate;

import java.util.Scanner;

/**@Level: Low-intermediate
 * @Problme: Add a number to an array. At each (N)th insertion, print the median number.
 * e.g) {3, 7, 8}=> 7 is the median. For the next insertion, {3, 7, 8, 10}=> (7+8)/2 = 7.5 is the median number.
 * @Condition: print the median number from 3rd insertion.
 *
 * @Solution:
 * 1)At each insertion, number is sorted and inserted (Insertion Sort)
 * 2)After each insertion sort, print the median.
 */
public class FindRunningMedian {


    public static void findMedianNumber(int[] numbers, int num,int lastPos){
        int num2;
        double median;
        /**Insertion Sort(Non-decreasing)**/
        for (int i =lastPos-1; i>=0; i--){
            num2 = numbers[i];
            if (num < num2){
                numbers[i+1]=num2;
                numbers[i]=num;
            }else
                break;
        }
        if (lastPos<2) return;

        if (lastPos%2==0){ //Odd Number (Zero base index)
            median = (double)numbers[lastPos/2]; //Should be cast for the result of computation in double
       }else//Even Number
            median = (double)(numbers[lastPos/2]+numbers[lastPos/2+1])/2;
        System.out.println(median);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            if (a_i==0) continue;
            findMedianNumber(a, a[a_i], a_i);
        }
    }
}
