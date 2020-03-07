package com.company.problem.easy;

import java.util.*;

/**
 * @Level Of Difficulty : medium-Low Level
 *
 * @Problem: Find out a give tree is BST or Not.
 *
 * @Condition:  0<=value <= 10^4
 *
 * @Solution: In BST, a Node should be larger or smaller than a parent and grandparent(This is why to set min and max values.
 * 1. Traverse nodes in a recursive way.
 * 2. Setting a Max value and a Min value to prevent duplicate nodes.
*
* @Further Study : define a function with only one parameter.
 */

public class isBST {

    /**Answer : Solve the problem in a recursive way.
     * @param root
     * @param minValue
     * @param maxValue
     * @return
     */
    static boolean checkBST2(Node root, int minValue, int maxValue) {
        int min=minValue;
        int max=maxValue;
        if (root==null) return true;
        if(root.data>max
                ||root.data<min) return false;

        return checkBST2(root.left, min,root.data-1)
                && checkBST2(root.right, root.data+1, maxValue);
    }


/**Imperfect Answer.
 * Not handle any of left descendants from root is not smaller than root, but bigger than its parent.(right child of parent)
 * */
    static boolean checkBST(Node root) {
        Set<Integer> set = new HashSet<>();
        Queue<Node> queue = new LinkedList();
        Node head;
        queue.offer(root);
        int upBound =root.data; //Upper Bound of Left
        int lowBound = root.data;//Lower Bound of Right
        boolean isBST =true;
        while ( !queue.isEmpty() && isBST){
            head = queue.peek();
            if (head.left!=null){
                if(head.left.data < head.data &&
                        !set.contains(head.left.data)){
                    queue.offer(head.left);
                    set.add(head.left.data);

                }
                else
                    isBST =false;
            }
            if(head.right!=null){
                if (head.right.data > head.data &&
                        !set.contains(head.right.data)){
                    queue.offer(head.right);
                    set.add(head.right.data);
                }
                else
                    isBST = false;
            }
            queue.poll();
        } //Finish if All of nodes are traversed, Tree is BST. Or Not BST.
        return isBST;
    }

    public static void main(String[] args){
        Node node6 = new Node( 6, null, null);
        Node node5 = new Node( 4,null, null);
        Node node2 = new Node( 2, null, node5);
        Node node3 = new Node( 8, node6, null);
        Node root = new Node ( 5, node2, node3);
        System.out.println("This tree is BST :"+ checkBST2(root,0, 10^4)); //OK

    }
}
