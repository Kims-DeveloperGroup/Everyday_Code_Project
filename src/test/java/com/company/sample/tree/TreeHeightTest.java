package com.company.sample.tree;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeHeightTest {
    private static TreeHeight treeHeight = new TreeHeight();
    public static Node testTree;

    @BeforeAll
    public static void buildTestTree() {
        //Root level
        Node root = new Node("A");
        root.isRoot = true;

        //2nd
        Node rootChildA = new Node("A-A");
        Node rootChildB = new Node("A-B");
        Node rootChildC = new Node("A-C");
        root.addChildren(rootChildA, rootChildB, rootChildC);

        //3rd
        Node aaa = new Node("A-A-A");
        rootChildA.addChild(aaa);
        Node aba = new Node("A-B-A");
        rootChildB.addChild(aba);
        Node aca = new Node("A-C-A");
        rootChildC.addChild(aca);

        //4th
        Node acaChildA = new Node("A-C-A-A");
        aca.addChild(acaChildA);
        Node abaChildA = new Node("A-B-A-A");
        aba.addChild(abaChildA);

        //5th
        Node acaaChildA = new Node("A-C-A-A-A");
        acaChildA.addChild(acaaChildA);

        testTree = root;
    }

    @Test
    public void findTwoLongestPath_thenReturningFirstlyAndSeconlyDeepestNodes() {
        // Given

        // When
        Node deepest = treeHeight.findTheDeepestNode(testTree);

        // Then
        assertThat(deepest.value).isEqualTo("A-C-A-A-A");
    }

    @Test
    public void getDistanceBetween_whenOneNodeIsRootAndAnotherNodeIsItsChild_thenDistanceShouldBe1() {
        // Given
        String root = "A";
        String rootChildA = "A-A";

        // When
        int height = treeHeight.getDistanceBetween(testTree, root, rootChildA);

        // Then
        assertThat(height).isEqualTo(1);
    }

    @Test
    public void getDistanceBetween_whenOneIsGrandChildOfRootAndAnotherIsItsChild_thenDistanceShouldBe1() {
        // Given
        String grandChildOfRoot = "A-C-A";
        String itsChild = "A-C-A-A";

        // When
        int height = treeHeight.getDistanceBetween(testTree, grandChildOfRoot, itsChild);

        // Then
        assertThat(height).isEqualTo(1);
    }

    @Test
    public void getDistanceBetween_whenOneIsRootChildAAndAnotherIsChildOfRootChildB_thenDistanceShouldBe3() {
        // Given
        String rootChildA = "A-A";
        String childAOfRootChildB = "A-B-A";

        // When
        int height = treeHeight.getDistanceBetween(testTree, rootChildA, childAOfRootChildB);

        // Then
        assertThat(height).isEqualTo(3);
    }

    @Test
    public void testGetTreeHeight_whenNoChildToFindExists() {
        // Given
        String root =  "A";
        String nonExisting = "NO";

        // When
        int distanceBetween = treeHeight.getDistanceBetween(testTree, root, nonExisting);


        // Then
        assertThat(distanceBetween).isEqualTo(0);
    }
}