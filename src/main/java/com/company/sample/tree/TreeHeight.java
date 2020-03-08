package com.company.sample.tree;

public class TreeHeight {

    /**
     *
     * @param tree
     * @param pointA a value of a node in a given tree
     * @param pointB a value of a node in a given tree
     * @return the distance between pointA node and pointB node in tree
     */
    public int getDistanceBetween(Node tree, String pointA, String pointB) {

        if ((tree.value.equals(pointA) || tree.value.equals(pointB)) && tree.children.size() == 0) {
            return 1;
        }

        if (tree.children.size() == 0) {
            return 0;
        }

        int height = 0;

        for (Node subTree : tree.children) {
            height += getDistanceBetween(subTree, pointA, pointB);
        }
        if (tree.isRoot) {
            return Math.abs(height);
        } else if (tree.value.equals(pointA) || tree.value.equals(pointB)) {
            if (height == 0) {
                return 1;
            } else {
                return - height;
            }
        }

        return height > 0 ? height + 1 : height;
    }
}
