package com.company.problem.hard;

/**
 * When one of the elements is removed from an array and the higher indexed elements shift to the left and fill the empty space.
 * In the case, when the sum of even-indexed elements is equal to the sum of the odd-indexed, the removed element is called balancing element.
 * Expected answer:
 * a count of balancing elements in a given array.
 */
public class BalancingElements {

    /**
     * Time complexity 2 * O(n) * c => O(n)
     *
     * @param unbalancedElements
     * @return the count of balancing elements
     */
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

    /**
     * The WAY OF REBUILDING partialSum after removal
     * arr: [0 1 2 3 4 5]
     * partialEvenAndOddSum
     * = [[0], [0]], [[0], [1]],  [[0 + 2], [1]]  [[0 + 2], [1 + 3]] [[0 + 2 + 4], [1 + 3]], [[0 + 2 + 4], [1 + 3 + 5]]
     *
     * CASE 1: Remove 0 from arr
     *
     * 0 removed and shift higher indexed elements to the left
     * arrAfterRemove: [1 2 3 4 5]
     *
     * Rebuilt partialSum after removal
     * [[1],[0]], [[1], [2]], [[1,3], [2]], [[1,3], [2. 4]], [[1, 3, 5], [2, 4]]
     *
     *
     * Rebuild the last element partialSum
     * [[0 + 2 + 4], [1 + 3 + 5] => [[1, 3, 5], [2, 4]]
     *
     * 1. Subtract by partialSum till the removed element
     * partialSum[last] - partialSum[0]
     *  = [[0 + 2 + 4], [1 + 3 + 5]] - [[0], [0]] = [[2 + 4], [1 + 3 + 5]]
     *
     * 2. Swap the position
     * partialSum[last][0] = partialSum[last][1]  partialSum[last][1] = partialSum[last][0]
     * [[2 + 4], [1 + 3 + 5]] => [[1 + 3 + 5], [2 + 4]] //
     *
     *
     *
     * CASE 2: Remove 3 located in the middle of arr
     * 3 removed and shift higher indexed elements to the left
     * [[0], []], [[0], [1]],  [[0, 2], [1]]  [[0, 2, 4], [1, 3]], [[0, 2, 4], [1, 3, 5]]
     *
     * 1. Subtract by partialSum till the removed element
     * partialSum[last] - partialSum[0]
     *  = [[0, 2, 4], [1, 3, 5]] - [[0, 2], [1, 3]] = [[4], [5]]
     * 2. Swap the position
     *  [[4], [5]] => [[5], [4]]
     *
     * 3. Sum partialSum before the removed element
     * [[5], [4]] + [[0 + 2], [1]] = [0 + 2 + 5], [1 + 4]
     */

}