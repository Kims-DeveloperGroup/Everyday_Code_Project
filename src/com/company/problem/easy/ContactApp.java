package com.company.problem.easy;

import java.util.*;

/**
 * @Level: Very low-Easy
 * @Problem:
 * 1) Implement your own contact application, which offers only two commands, add and find.
 * 2) The result of find operation is the number of name, which contains a given name as a sub-String.
 * @Solution: Use a map to add name to the contact <name, counts of names>. For 'find operation', simply String.contain(Charsequence) is used.
 */
public class ContactApp {

    public static Map<String, Integer> map = new HashMap<>();


    public static void operateInContact(String op, String name){

        if (op.equals("add")){
            if (map.containsKey(name)) map.put(name.toLowerCase(), map.get(name)+1);
            else map.put(name.toLowerCase(), 1);

        }else if(op.equals("find")){
            int count=0;
            Set<String> set = map.keySet();
            for (String aName : set){
                if (aName.contains(name.toLowerCase())) count++;
            }
            System.out.println(name +": "+count+" found");
        }else
            System.out.println("Invalid Command. Please try again!");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String op = in.next();
            String contact = in.next();
            operateInContact(op, contact);
        }
    }
}
