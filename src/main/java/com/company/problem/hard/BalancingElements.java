package com.company.problem.hard;

public class BalancingElements {
    public int countBalancingElemetns(int[] unbalancedElements) {
        int count = 0;
        for (int i = 0; i < unbalancedElements.length; i++) {
            if (isBalanced(unbalancedElements, i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBalanced(int[] elements, int balancingElementIndex) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < elements.length; i++) {
            if (i < balancingElementIndex) {
                if (((i % 2) == 0)) {
                    evenSum += elements[i];
                } else {
                    oddSum += elements[i];
                }
            } else if (i > balancingElementIndex) {
                int repositioned = i - 1;
                if (((repositioned % 2) == 0)) {
                    evenSum += elements[i];
                } else {
                    oddSum += elements[i];
                }
            }
        }
        return evenSum == oddSum;
    }
}