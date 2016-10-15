package com.company.problem.easy;

/**
 * @Level Of Difficulty : Low Level
 *
 * @Problem: Find a Node or its children which has a given data and return 'true/false'
 *
 * @Solution: Search a node and children recursively
 */
class Node {
    public int data;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.data = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node node, int value) {

        Node curr =node;
        boolean found=false;
        while(curr!=null){
            if(curr.data == value){
                found=true;
                break;
            }else if(curr.data > value) curr= curr.left;
            else curr = curr.right;
        }
        return found;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("Searching....");
        System.out.println(bst.contains(n2, 3));
        System.out.println("Done!");
    }

}
