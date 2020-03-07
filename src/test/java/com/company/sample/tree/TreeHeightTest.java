package com.company.sample.tree;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GetTreeHeightTest {
    private static final GetTreeHeight getTreeHeight = new GetTreeHeight();

    @Test
    public void testGetTreeHeight_whenTwoNodesToFindAreParentAndChild() {
        // Given
        Node root = new Node("A");
        String childToFind = "C";
        root.addChildren("B", childToFind);

        // When
        int height = getTreeHeight.getHeightFromChild(root, childToFind);

        // Then
        Assertions.assertThat(height).isEqualTo(1);
    }

    @Test
    public void testGetTreeHeight_whenTwoNodesToFindAreParentAndChild_case2() {
        // Given
        Node root = new Node("A");
        String toFind = "E";
        root.addChildren("B", "C");
        Node rootChild = new Node("D");
        rootChild.addChildren(toFind);
        root.addChild(rootChild);


        // When
        int height = getTreeHeight.getHeightFromChild(root, toFind);

        // Then
        Assertions.assertThat(height).isEqualTo(2);
    }

    @Test
    public void testGetTreeHeight_whenNoChildToFindExists() {
        // Given
        Node root = new Node("A");
        String childToFind = "D";
        root.addChildren("B", "C");

        // When

        int height = 0;
        for (Node child : root.children) {
            height += getTreeHeight.getHeightFromChild(root, childToFind);
        }

        // Then
        Assertions.assertThat(height).isEqualTo(0);
    }
}