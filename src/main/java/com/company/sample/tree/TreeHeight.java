package com.company.sample.tree;

public class TreeHeight {

    public int getDistanceBetween(Node treeRoot, String pointA, String pointB) {
        int height = 0;
        for (Node child : treeRoot.children) {
            height += getHeightFromChildContainingValues(child, pointA, pointB);
        }
        System.out.println("Distance: " + height);
        return  height;
    }

    private int getHeightFromChildContainingValues(Node node, String pointA, String pointB) {

        if (node.value.equals(pointA) || node.value.equals(pointB)) {
            return 1;
        }

        if (node.children.size() == 0) {
            return 0;
        }

        int height = 0;
        for (Node child : node.children) {
            height += getHeightFromChildContainingValues(child, pointA, pointB);
        }
        return height > 0 ? height + 1 : 0;
    }
}
