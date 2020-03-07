package com.company.problem.easy;


import java.util.HashSet;
/**
 * @Level Of Difficulty : Low Level
 *
 * @Problem: Find a linked list is circular. And return 'true/false'
 *
 * @Solution: Traverse a list and Add a visited node to Set. If any node is re-visited during traverse, return true.
 * Otherwise return false since the list is not circular
 */
class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value, ListNode nextNode) {
        this.value = value;
        this.next = nextNode;
    }
}


public class CircularQueue {

    public static boolean circular(ListNode head){
        HashSet visited = new HashSet<ListNode>();
        ListNode curr = head;

        while (curr!=null){
            if (visited.contains(curr)){
                System.out.println("Re-Visit position: " + curr.value);
                return true;
            }
            System.out.println("Current Position: " + curr.value);
            visited.add(curr);
            curr =curr.next;
        }
        return false;
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        node4.next = node4;
        node1.next= node3;
        System.out.println("Linked List is Circular: "+ circular(node4));

    }
}
