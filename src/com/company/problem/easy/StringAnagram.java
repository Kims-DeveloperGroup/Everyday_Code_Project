package com.company.problem.easy;

/**
 * @Level of Difficulty : Low-easy
 * @Problem: In two of given strings,   find the same characters in the same frequency. Return the number of unmatched chars in the both strings.
 *
 * @Solution:
 *
 * 1. Compare the string with another sequentially.
 * 2. If the same char is found, remove it in the compared strings. And increment the countStroke of matched chars.
 * 3. Finally return the sum of length of them.
 */
public class StringAnagram {


    public static int findAnagram(String first, String second){

        char[] chars1 =first.toCharArray();
        char[] chars2 =second.toCharArray();
        int count=0;
        String matched="";

        for (char char1 : chars1){

            for (int i=0 ;i<chars2.length; i++){

                char char2 = chars2[i];
                if(char1==char2){
                    chars2[i]= ' ';//To prevent from duplicate countStroke.
                    count++;
                    matched+=char1;
                    break;
                }
            }
        }
        System.out.println("Matched Chars: "+ matched);
        return (first.length()-count)+(second.length()-count);
    }

    public static void main(String[] args){
        System.out.println("Removed number of chars is "+ findAnagram("apple","awesome"));
    }
}
