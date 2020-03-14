package com.company.sample.tree.btree;

import com.company.sample.tree.Node;
import org.junit.Before;

class BinaryTreeNodeRemovalTest {
    private static Node testTree;


    //           31
    //          /   \
    //         17   72
    //             /   \
    //           55    82
    //          /  \
    //        49   69
    @Before
    public void buildFullBinarySearchTree() {
        //Root level
        Node root = new Node(31);
        root.isRoot = true;
        testTree = root;

        //2nd
        Node leftChildOfRoot = new Node(17);
        Node rightChildOfRoot = new Node(72);
        root.leftChild = leftChildOfRoot;
        root.rightChild = rightChildOfRoot;

        //3rd
        Node leftOfRightRootChild = new Node(55);
        Node rightOfRightRootChild = new Node(82);
        rightChildOfRoot.leftChild = leftOfRightRootChild;
        rightChildOfRoot.rightChild = rightOfRightRootChild;

        //4th
        Node leftChildOfRightChildOfRightRootChild = new Node(69);
    }
}