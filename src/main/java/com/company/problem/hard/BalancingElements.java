package com.company.problem.hard;

import java.util.ArrayList;

/**
 * When one of the elements is removed from an array and the higher indexed elements shift to the left and fill the empty space.
 * In the case, when the sum of even-indexed elements is equal to the sum of the odd-indexed, the removed element is called balancing element.
 * Expected answer:
 * a count of balancing elements in a given array.
 */
public class BalancingElements {
    public int countBalancingElemetns(int[] unbalancedElements) {
        int wholeSum = 0;
        for (int number : unbalancedElements) {
            wholeSum += number;
        }

        int count = 0;
        for (int i = 0; i < unbalancedElements.length; i++) { //O(n^2)

            if (((wholeSum - unbalancedElements[i]) % 2) != 0) {
                continue;
            }

            if (isBalanced(unbalancedElements, i, wholeSum)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBalanced(int[] elements, int balancingElementIndex, int wholeSum) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < elements.length; i++) {
            if (balancingElementIndex == i) {
                continue;
            }

            int leftShifted = (i > balancingElementIndex) ? i - 1 : i;

            if ((leftShifted % 2) == 0) {
                evenSum += elements[i];
            } else {
                oddSum += elements[i];
            }

            if (oddSum > (wholeSum / 2) || (evenSum > (wholeSum / 2))) {
                break;
            }
        }
        return evenSum == oddSum;
    }
}