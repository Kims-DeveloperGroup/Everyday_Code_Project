package com.company.sample.tree;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TreeHeightTest {
    private static TreeHeight treeHeight = new TreeHeight();

    @Test
    public void getDistanceBetween_whenOneNodeIsRootAndAnotherNodeIsItsChild_thenDistanceShouldBe1() {
        // Given
        Node root = new Node("A");
        String pointA = "A";
        String pointC = "C";
        root.addChildren("B", pointC);

        // When
        int height = treeHeight.getDistanceBetween(root, pointA, pointC);

        // Then
        Assertions.assertThat(height).isEqualTo(1);
    }

    @Test
    public void getDistanceBetween_whenOneIsRootAndAnotherIsItsGrandChild_thenDistanceShouldBe2() {
        // Given
        Node root = new Node("A");
        String pointF = "A";
        String pointE = "E";
        root.addChildren("B", "C");
        Node childOfRoot = new Node("D");
        Node grandChildOfRoot = new Node(pointE);
        childOfRoot.addChild(grandChildOfRoot);
        root.addChild(childOfRoot);
        Node childOfGrandChildOfRoot = new Node(pointF);
        grandChildOfRoot.addChild(childOfGrandChildOfRoot);


        // When
        int height = treeHeight.getDistanceBetween(root, pointF, pointE);

        // Then
        Assertions.assertThat(height).isEqualTo(1);
    }

    @Test
    public void getDistanceBetween_whenOneIsOneIsChildOfRootAndAnotherIsItsChild_thenDistanceShouldBe2() {
        // Given
        Node root = new Node("A");
        String pointD = "D";
        String pointE = "E";
        root.addChildren("B", "C");
        Node childOfRoot = new Node("D");
        Node grandChildOfRoot = new Node(pointE);
        childOfRoot.addChild(grandChildOfRoot);
        root.addChild(childOfRoot);


        // When
        int height = treeHeight.getDistanceBetween(root, pointD, pointE);

        // Then
        Assertions.assertThat(height).isEqualTo(2);
    }

    @Test
    public void getDistanceBetween_whenOneIsChildOfRootAndAnotherIsGrandChild_thenDistanceShouldBe3() {
        // Given
        Node root = new Node("A");
        String pointB = "B";
        String pointE = "E";
        root.addChildren("B", "C");
        Node rootChild = new Node("D");
        rootChild.addChildren(pointB);
        root.addChild(rootChild);


        // When
        int height = treeHeight.getDistanceBetween(root, pointB, pointE);

        // Then
        Assertions.assertThat(height).isEqualTo(3);
    }

    @Test
    public void testGetTreeHeight_whenNoChildToFindExists() {
        // Given
        Node root = new Node("A");
        String pointA = "A";
        String notExistingPoint = "D";
        root.addChildren("B", "C");

        // When
        int distanceBetween = treeHeight.getDistanceBetween(root, pointA, notExistingPoint);


        // Then
        Assertions.assertThat(distanceBetween).isEqualTo(0);
    }
}