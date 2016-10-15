package com.company.problem.easy;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Level : Low-easy
 *@Problem: Implement the three operations of Queue by using Two of Stack. op1: enqueue, op2: dequeue, op3: peek
 * @Solution:
 * 1. Make two stacks named by left and right. the left is LIFO and right is FIFO.
 * 2. In case of enqueue, the left stack is used. But in case of dequeue/peek, the right is used.
 */

class MyQueue<T1>{
    private Stack<T1> left = new Stack<T1>();
    private Stack<T1> right = new Stack<T1>();


    public void enqueue(T1 n){
        if (right.isEmpty() && !left.isEmpty()) left.push(n);
        else if (left.isEmpty() && !right.isEmpty()){
            while(!right.isEmpty()){
                left.push(right.pop());
            }
            left.push(n);
        }else
            left.push(n);

    }
    public void dequeue(){
        if (left.isEmpty() && !right.isEmpty()) right.pop();
        else if (right.isEmpty() && !left.isEmpty()){
            while (!left.isEmpty()){
                right.push(left.pop());
            }
            right.pop();
        }
    }

    public T1 peek(){
        if (left.isEmpty() && !right.isEmpty()) return right.peek();
        else if (right.isEmpty() && !left.isEmpty()){
            while (!left.isEmpty()){
                right.push(left.pop());
            }
            return right.peek();
        }else
            return null;
    }

    @Override
    public String toString() {
        String str="";
        if (right.isEmpty() && !left.isEmpty()) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }

        while (!right.isEmpty()){
            str =str+" "+right.pop();
        }
        return str;
    }
}

public class QueueOperation {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { /** enqueue**/
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { /** dequeue**/
                queue.dequeue();
            } else if (operation == 3) { /** peek **/
                System.out.println(queue.peek());
            }
        }
        scan.close();
        System.out.println("Result: "+queue.toString());
    }
}
