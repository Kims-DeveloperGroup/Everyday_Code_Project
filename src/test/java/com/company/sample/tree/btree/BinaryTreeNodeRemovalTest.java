package com.company.sample.tree.btree;

import com.company.sample.tree.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeNodeRemovalTest {
    private static BinaryTreeNodeRemoval binaryTreeNodeRemoval = new BinaryTreeNodeRemoval();
    private static Node testTree;


    //           31
    //          /   \
    //         17   72
    //             /   \
    //           55    82
    //          /  \
    //        49   69
    @BeforeAll
    public static void buildFullBinarySearchTree() {
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
        Node leftChildOfLeftChildOfRightRootChild = new Node(49);
        Node rightChildOfLeftChildOfRightRootChild = new Node(69);
        leftOfRightRootChild.leftChild = leftChildOfLeftChildOfRightRootChild;
        leftOfRightRootChild.rightChild = rightChildOfLeftChildOfRightRootChild;
    }

    @Test
    public void removeRightChildNode_thenReturnedTreeShouldBeBinarySearchTree() {
        // Given

        // When
        testTree.rightChild = binaryTreeNodeRemoval.removeRootNodeOfBSearchTre(testTree.rightChild);

        // Then
        assertThat(verifyBtree(testTree)).isTrue();
    }

    @Test
    public void testVerifyBtree_whenValidBinarySearchTreeIsGiven_thenReturningTrue() {
        // Given

        // When
        boolean validBtree = verifyBtree(testTree);

        // Then
        assertThat(validBtree).isTrue();
    }

    private boolean verifyBtree(Node tree) {
        LinkedList<Node> ascending = traverseInOrder(tree);
        Node prev = null;

        for (Node node : ascending) {
            System.out.println(node.numericValue);
            if (prev == null) {
                prev = node;
            } else {
                if (node.numericValue < prev.numericValue) {
                    return false;
                }
            }
        }
        return true;
    }

    private LinkedList<Node> traverseInOrder(Node parent) {
        LinkedList<Node> sorted = new LinkedList<>();
        if (parent.leftChild != null) {
            sorted.addAll(traverseInOrder(parent.leftChild));
        }
        sorted.add(parent);
        if (parent.rightChild != null) {
            sorted.addAll(traverseInOrder(parent.rightChild));
        }
        return sorted;
    }
}