package com.company.xxxxgames;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Level Of Difficulty : Low Level
 *
 * @Problem: Traverse value of each node from the lowest level to root.
 *
 * @Solution: Traverse an each level(Breadth Search) and push the each node to the stack from parent to child.
 */


public class TraverseFromLowerLevelToUpper {

    static private class Node{
        int value;
        Node parent;
        Node[] children;

        public Node(int value, Node parent, Node[] children) {
            this.value = value;
            this.parent = parent;
            this.children = children;
        }

        public Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.children = null;
        }
    }

    /**
     * @param queue: store nodes, which are not visited yet. if it's empty, no more nodes exists to be visited.
     * @param stack: store the nodes: to print values in the reverse order of input.
     */

    public void traverse(Queue<Node> queue, Stack<Node> stack){
        if (queue.isEmpty()){ //finishes and prints results.
            while (!stack.isEmpty()){
                Node node = stack.pop();
                System.out.println(node.value);
            }
            return;
        }

        //Depth Search
        Node curr = queue.poll();
        if (curr.children!=null) {
            for (Node child : curr.children) {
                queue.add(child);
            }
        }
        stack.push(curr); //FILO , reverses the order of input nodes.
        traverse(queue, stack);
    }

    public void depathSearch(Node root, Stack<Node> stack){
        stack.push(root);
        if (root.children!=null){
            for (Node child : root.children)
                depathSearch(child, stack);
        }
        stack.pop();
        System.out.println(root.value);
    }

    public static void main(String[] args){
        TraverseFromLowerLevelToUpper problem = new TraverseFromLowerLevelToUpper();
        Node root = new Node(1, null, null);
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);
        problem.traverse(queue, stack);
    }
}
