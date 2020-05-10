package com.company.problem.hard;

public class BalancingElements {
    public int countBalancingElemetns(int[] unbalancedElements) {
        int wholeSum = 0;
        for (int number : unbalancedElements) {
            wholeSum += number;
        }

        int count = 0;
        for (int i = 0; i < unbalancedElements.length; i++) {
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