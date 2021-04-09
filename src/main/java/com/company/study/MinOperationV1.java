package com.company.study;


/**
 * TimeComplexity O(N)
 */
public class MinOperationV1 {
    public int minOperations(int n) {

        // [1, 3, 5, 7] leftValue: 3, rightValue: 5
        //
        // [1, 3, 5, 7, 9] leftValue: 3, righValue: 7
        int ret = 0;
        int mIdx = n/2; // 2


        int x; //왼쪽으로 이동할 예정 --  // 2
        int y; // 오른쪽으로 이동할 예정 ++// 2
        if (n % 2 == 1) {
            x = mIdx - 1;
            y = mIdx + 1;
        } else {
            x = mIdx - 1;
            y = mIdx;
        }

        int leftValue = getValue(x); //
        int rightValue = getValue(y); //

        while(true) {

            if(x >= 0) {
                // Move left
                leftValue = getValue(x--); // leftValue = 1 x = 0 -> x = -1
            }

            if (y < n) {
                rightValue = getValue(y++); // rightValue = 5, y = 2 -> y = 3
            }

            while (true) {
                leftValue++;  // 4
                rightValue--; // 6
                ret++; // ret = 1
                if(leftValue == rightValue) {
                    break;
                }
            }
            if(x < 0) {
                break;
            }
        }
        return ret;
    }

    private int getValue(int idx) {
        return (2 * idx) + 1;
    }
}
