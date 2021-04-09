package com.company.study;

/**
 * Time complexity O(1)
 */
public class MinOperationV2 {

    // [1 (2), 3,(2) 5]  answer =2
    //[1(4), 3(2), 5, (2) 7,(4) 9]  = answer=6
    //[1(6), 3(4), 5(2),  7, 9, 11, 13]  2 * 1 + 2* 2, ..... + 2 * (n/2)

    // O(n)
    public int minOperations(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 != 0) {
            return sumOdds(n/2);
        } else {
            return sumEvens(n/2);
        }
    }

    private int sumOdds(int n) {
        return n * (n + 1);
    }

    private int sumEvens(int n) {
        return n * (n-1 ) + n;
    }

    /*
    홀수: 2 6 12 20 = 시그마 (2*n) -> 2 * 시그마(n) =  (n-1) * (n)
          2 4 6 8 -> a(n) = 2*n
    짝수: 1 4 9 16 -> 시그마 (2*n + 1) ->  1 + n * (n-1) + (n-1) = n * (n-1) + n
          3 5 7 9 -> a(n) = 2*n + 1
     */
}
