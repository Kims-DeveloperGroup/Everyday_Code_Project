package com.company.sample.tree;

public class GetTreeHeight {

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
            height += getHeightFromChild(child, childToFind);
        }
        return height > 0 ? height + 1 : 0;
    }
}
