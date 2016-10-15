package com.company.problem.intermediate;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * @Level Of Difficulty : Low-intermediate Level  :
 *
 * @Problem: Find out a given set of brackets is balanced on Not.  (Stack)
 *
 * @Solution:
 * 1.Keep in mind that when closing a bracket, there should be a opening bracket of the same type.
 * 2-1. opened brackets should be closed in the reverse order of opening.
 * 2-2. That's why pop() of Stack is used for closing brackets.
 * @Exception : Right Bracket is open before the matched left bracket.
 *
 * Get a problem too much complicated doesn't help you.
 *
 * Begin with simple case and sub problem.
 */

public class BalancedBrackets {


    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        char top;

        for (int i=0; i<s.length(); i++){
            char bracket = s.charAt(i);

            if(bracket =='(' || bracket =='{' || bracket == '[')
                stack.push(bracket);
            else{
                if (stack.isEmpty()) return  false;
                top =stack.pop();
                if ( (top =='(' && bracket != ')') ||
                        (top =='{' && bracket != '}') ||
                        (top == '[' && bracket != ']')
                        ) return false;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}")); //Yes
        System.out.println(isBalanced("{[(])}")); //No
        System.out.println(isBalanced("{{[[(())]]}}")); //Yes
    }
}
