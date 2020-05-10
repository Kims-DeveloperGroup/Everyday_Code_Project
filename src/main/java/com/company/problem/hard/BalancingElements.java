package com.company.problem.hard;

/**
 * When one of the elements is removed from an array and the higher indexed elements shift to the left and fill the empty space.
 * In the case, when the sum of even-indexed elements is equal to the sum of the odd-indexed, the removed element is called balancing element.
 * Expected answer:
 * a count of balancing elements in a given array.
 */
public class BalancingElements {
    public int countBalancingElemetns(int[] unbalancedElements) {
        int[][] partialSum = buildPartialOddAndEvenSum(unbalancedElements); //O(n)

        int count = 0;
        for (int i = 0; i < unbalancedElements.length; i++) { //O(n)
            if (isBalanced(i, partialSum.clone())) { // c
                count++;
            }
        }
        return count;
    }

    private int[][] buildPartialOddAndEvenSum(int[] unbalancedElements) {
        int wholeOddSum = 0;
        int wholeEvenSum = 0;
        int[][] partialSum = new int[unbalancedElements.length][2];
        for (int i = 0; i < unbalancedElements.length; i++) {//O(n)
            int number = unbalancedElements[i];
            if ((i % 2) == 0) {
                wholeEvenSum += number;
                if (i == 0) {
                    partialSum[0][0] = wholeEvenSum;
                    partialSum[0][1] = 0;

                } else {
                    partialSum[i][0] = wholeEvenSum;
                    partialSum[i][1] = partialSum[i - 1][1];
                }
            } else {
                wholeOddSum += number;
                partialSum[i][0] = partialSum[i - 1][0];
                partialSum[i][1] = wholeOddSum;
            }
        }
        return partialSum;
    }

    private boolean isBalanced(int indexToRemove, int[][] partialSum) {
        int lastIndex = partialSum.length - 1;

        int[] partialSumBeforeElement;
        if (indexToRemove == 0) {
            partialSumBeforeElement = new int[]{0, 0};
        } else {
            partialSumBeforeElement = partialSum[indexToRemove - 1];
        }

        int[] partialSumAfterRemovedElement = {partialSum[lastIndex][0] - partialSum[indexToRemove][0], partialSum[lastIndex][1] - partialSum[indexToRemove][1]};

        int even = partialSumAfterRemovedElement[0];
        partialSumAfterRemovedElement[0] = partialSumAfterRemovedElement[1];
        partialSumAfterRemovedElement[1] = even;

        int evenSum = partialSumAfterRemovedElement[0] + partialSumBeforeElement[0];
        int oddSum = partialSumAfterRemovedElement[1] + partialSumBeforeElement[1];
        System.out.println("indexToRemove:" + indexToRemove + " oddSum: " + oddSum + " evenSum: " + evenSum);
        return evenSum == oddSum;
    }
}