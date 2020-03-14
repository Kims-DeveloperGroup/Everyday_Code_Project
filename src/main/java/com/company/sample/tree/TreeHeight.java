package com.company.sample.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeHeight {

    /**
     * @param tree
     * @param pointA a value of a node in a given tree
     * @param pointB a value of a node in a given tree
     * @return the distance between pointA node and pointB node in tree
     */
    public int getDistanceBetween(Node tree, String pointA, String pointB) {
        //Base case 1: The current node is pointA or pointB, and no more children(subtree) exists to traverse.
        if ((tree.value.equals(pointA) || tree.value.equals(pointB)) && tree.children.size() == 0) {
            return 1;
        }
        //Base case 2: No more subtree(children) to traverse exists, and the current node is not pointA or pointB
        if (tree.children.size() == 0) {
            return 0;
        }

        //Sub-problem: get the height from the nodes(pointA or pointB) in the subtree.
        int height = 0;
        for (Node subTree : tree.children) {
            height += getDistanceBetween(subTree, pointA, pointB);
        }

        //Exceptional case handling
        if (tree.isRoot) {
            //When current node is root, height does not increment height, and the current height is returned.
            return Math.abs(height);
        } else if ((tree.value.equals(pointA) || tree.value.equals(pointB)) && height == 0) {
            //When pointA or pointB does not exist in the subtree(children) of the current node.
            return 1;
        } else if ((tree.value.equals(pointA) || tree.value.equals(pointB)) && height > 0) {
            //When the current node is pointA or pointB and a child node is pointA or pointB, a minus value of height is returned. Minus value means the distance'been already found so that the height should be returned as it is.
            //In the case, pointA and pointB are in the same subtree.
            return -height;
        }

        // When the current node is not pointA or pointB
        // height = 0 pointA or pointB does not exists in the subtree so that no height is returned.
        // height > 0 pointA or pointB exists in the subtree and the height should be incremented by 1 and returned.
        return height > 0 ? height + 1 : height;
    }

    public Node findTheDeepestNode(Node tree) {
        if (tree.children.size() == 0) {
            tree.depth = 0;
            return tree;
        }
        Node currentDeepestNode = null;
        for (Node subTree : tree.children) {
            Node deepestNode = findTheDeepestNode(subTree);
            if (currentDeepestNode == null) {
                currentDeepestNode = deepestNode;
            } else {
                currentDeepestNode = currentDeepestNode.depth >= deepestNode.depth ? currentDeepestNode : deepestNode;
            }
        }
        currentDeepestNode.depth = currentDeepestNode.depth + 1;
        return currentDeepestNode;
    }

    public List<Node> findTheLongestPathBetweenTwoNodes(Node tree) throws Exception {
        if (tree.children.size() == 0) {
            throw new Exception("The given tree has no child node");
        }
        LinkedList<Node> longestPath = new LinkedList<>();

        for (Node sub : tree.children) {
            Node deepest = findTheDeepestNode(sub);
            if (longestPath.size() == 0) {
                longestPath.push(deepest);
            } else if (longestPath.size() == 1) {
                if (longestPath.peekFirst().depth >= deepest.depth) {
                    longestPath.addLast(deepest);
                } else {
                    longestPath.addFirst(deepest);
                }
            } else {
                if (deepest.depth >= longestPath.peekFirst().depth) {
                    longestPath.removeLast();
                    longestPath.addFirst(deepest);
                } else if (deepest.depth > longestPath.peekFirst().depth && deepest.depth < longestPath.peekFirst().depth) {
                    longestPath.removeLast();
                    longestPath.addLast(deepest);
                }
            }
        }
        System.out.println(longestPath.get(0).depth + longestPath.get(1).depth + 2);
        return longestPath;
    }
}
