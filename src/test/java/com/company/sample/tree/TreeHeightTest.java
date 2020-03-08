package com.company.sample.tree;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TreeHeightTest {
    private static TreeHeight treeHeight = new TreeHeight();
    public Node testTree;
    @BeforeAll
    public static void buildTestTree() {
        Node root = new Node("A");
        Node rootChildA = new Node("A-A");
        Node rootChildB = new Node("A-B");
        Node rootChildC = new Node("A-C");
        root.addChildren(rootChildA, rootChildB, rootChildC);

        Node aaa = new Node("A-A-A");
        rootChildA.addChild(aaa);
        Node aba = new Node("A-B-A");
        rootChildB.addChild(aba);
        Node aca = new Node("A-C-A");
        rootChildC.addChild(aca);


        Node acaChildA = new Node("A-C-A-A");
        aca.addChild(acaChildA);
    }

    @Test
    public void getDistanceBetween_whenOneNodeIsRootAndAnotherNodeIsItsChild_thenDistanceShouldBe1() {
        // Given
        String root = "A";
        String rootChildA = "A-A";

        // When
        int height = treeHeight.getDistanceBetween(testTree, root, rootChildA);

        // Then
        Assertions.assertThat(height).isEqualTo(1);
    }

    @Test
    public void getDistanceBetween_whenOneIsGrandChildOfRootAndAnotherIsItsChild_thenDistanceShouldBe1() {
        // Given
        String grandChildOfRoot = "A-C-A";
        String itsChild = "A-C-A-A";

        // When
        int height = treeHeight.getDistanceBetween(testTree, grandChildOfRoot, itsChild);

        // Then
        Assertions.assertThat(height).isEqualTo(1);
    }

    @Test
    public void getDistanceBetween_whenOneIsChildOfRootAndAnotherIsGrandChild_thenDistanceShouldBe3() {
        // Given
        String root = "A";
        String grandChildOfRoot = "A-A-A";

        // When
        int height = treeHeight.getDistanceBetween(testTree, root, grandChildOfRoot);

        // Then
        Assertions.assertThat(height).isEqualTo(3);
    }

    @Test
    public void testGetTreeHeight_whenNoChildToFindExists() {
        // Given
        String root =  "A";
        String nonExisting = "NO";

        // When
        int distanceBetween = treeHeight.getDistanceBetween(testTree, root, nonExisting);


        // Then
        Assertions.assertThat(distanceBetween).isEqualTo(0);
    }
}