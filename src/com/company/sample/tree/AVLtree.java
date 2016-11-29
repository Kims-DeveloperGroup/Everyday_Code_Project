package com.company.sample.tree;

/**
 * Created by devoo-kim on 16. 11. 29.
 */
public class AVLtree {
    private class Node{
        Node parent;
        Node left;
        Node right;
        int value;
    }
    Node root;

    public void addToAVLtree(Node curr, Node newly){

        if (curr ==null) {
            curr = newly;
            Node par = curr.parent;
            Node grand = par.parent;

            if (grand==null || isBalanced(grand)) return; //Parent is root or  balanced already.
            //Otherwise rotate a tree.
            if (grand.left == par
                    && par.left == curr)
                rightRotate(grand, grand.parent);
            else if (grand.right == par
                    && par.right == curr)
                leftRotate(grand, grand.parent);
            else {
                if (grand.left == par
                        && par.right == curr) {
                    leftRotate(par, grand);
                    rightRotate(grand, grand.parent);
                }else {
                    rightRotate(par, grand);
                    leftRotate(grand, grand.parent);
                }
            }
            return;
        }

        newly.parent =curr;
        if (curr.value > newly.value) {
            addToAVLtree(curr.left, newly);
        }
        else
            addToAVLtree(curr.right, newly);
    }

    public boolean isBalanced(Node root){
        //Compare the heights of left and right children
        //and, find out whether a given tree is balanced.
        return false || true;
    }

    public void leftRotate(Node node, Node parent){
        Node root = node.left;
        node.left = root.right;
        root.right =node;
        root.parent =node.parent;
        node.parent =root;

        if (parent !=null) { //node isn't root.
            if (parent.left == node) parent.left = root;
            else parent.right = root;
        }
    }

    public void rightRotate(Node node, Node parent){
        Node root = node.right;
        root.left =node;
        node.right =root.left;
        root.parent =node.parent;
        node.parent=root;

        if (parent!=null) { //node isn't root.
            if (parent.left == node) parent.left = root;
            else parent.right = root;
        }
    }

}
