package com.company.sample.tree;

/**
 * @Problem: Find out a given tree is balanced or not.
 *
 * @Solution:
 *  A balanced tree means that the difference of heights of left and right child is less than 2, and
 *  all the subtrees are balanced.
 */
public class isBalancedTree {

    private class Node{
        public Node left;
        public Node right;
        public int value;
    }

    /** Time Complexity : O(n^2)
     * Checks a given tree is balanced or not after getting the heights of the left and right child.
     */
    public boolean isBalanced(Node root){
        int diff = Math.abs(getHeight(root.left)-getHeight(root.right));
        if (diff >2) return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }

    /**Time Complexity: O(n)
     * Only gets the height of tree.
     */
    int getHeight(Node root){
        if (root ==null) return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /** Time Complexity: O(n)
     * Recursively traverses subtrees and finds out whether the tree is balanced.
     * @return the height if the tree is balanced, otherwise, returns -1;
     */

    public int isBalanced2(Node root){
        if (root ==null) return 0;
        int left = isBalanced2(root.left);
        int right = isBalanced2(root.right);
        int diff = Math.abs(left-right);

        if (left!=-1 && right!=-1
                && diff<2) return 1 + Math.max(left, right);
        else
            return -1;
    }


    public static void main(String[] args){
        isBalancedTree problem = new isBalancedTree();
        if (problem.isBalanced2(null)== -1)
            System.out.println("Tree is Balanced.");
        else
            System.out.println("Tree is Unbalanced.");


    }
}
