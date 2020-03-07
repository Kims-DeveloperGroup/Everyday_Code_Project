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

    public int getHeightFromChild(Node node, String childToFind) {
        System.out.println(node.value);
        System.out.println(node.children.toString());
        if (node.value.equals(childToFind)) {
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
