package com.company.sample.tree.btree;

import com.company.sample.tree.Node;

public class BinaryTreeNodeRemoval {

    public Node removeRootNodeOfBSearchTre(Node binarySearchTree) {
        Node prevLeft = binarySearchTree.leftChild;
        binarySearchTree.numericValue = prevLeft.numericValue;
        binarySearchTree.rightChild = mergeBTree(binarySearchTree.rightChild, prevLeft.rightChild);
        binarySearchTree.leftChild = prevLeft.leftChild;
        return binarySearchTree;
    }

    public Node mergeBTree(Node bigger, Node smaller) {
        if (bigger.leftChild == null) {
            bigger.leftChild = smaller;
            return bigger;
        }
        bigger.leftChild = mergeBTree(bigger.leftChild, smaller);
        return bigger;
    }
}
