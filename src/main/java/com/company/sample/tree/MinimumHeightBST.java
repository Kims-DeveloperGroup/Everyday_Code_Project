package com.company.sample.tree;

/**
 * @Problem:
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 *
 * @Solution:
 * In order to make a tree with a minimum height, the root should has the middle value of them.
 */
public class MinimumHeightBST {
    private class Node{
        Node left;
        Node right;
        int value;
        public Node(int value){
            this.value =value;
        }
    }

    Node root;

    /**
     * Creates Minimal Binary Search Tree, which has the minimum height.
     * @param root of the tree to add a new node.
     * @param entries entries to be added
     * @param first first index of range of an array, which have not been added yet.
     * @param last last index of range.
     */
    public void makeMinimalBST(Node root, int[] entries, int first, int last){

        int mid = (first+last)/2+1;
        add(root, new Node(entries[mid]));

        if (first<mid)
            makeMinimalBST(root.left, entries, first, mid - 1);

        if (last>mid)
            makeMinimalBST(root.right, entries, mid + 1, last);
    }

    /**
     * Add an new node into BST.
     * @param root a root of tree to add a new node.
     * @param newly to be added into BST
     */
    public void add(Node root, Node newly){
        if (root==null) root = newly;
        if (newly.value> root.value) add(root.right, newly);
        else
            add(root.left, newly);
    }
}
