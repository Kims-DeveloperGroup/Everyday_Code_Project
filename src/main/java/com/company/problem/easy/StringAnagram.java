package com.company.problem.easy;

/**
 * @Level of Difficulty : Low-easy
 * @Problem: In two of given strings,   find the same characters in the same frequency. Return the number of unmatched chars in the both strings.
 *
 * @Solution:
 *
 * 1. Compare the string with another sequentially.
 * 2. If the same char is found, remove it in the compared string. And increment the countStroke of matched chars.
 * 3. Finally return the sum of length of them.
 */
public class StringAnagram {

    /**
     * Time complexity: O(n^2)
     */
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

    /**
     * Time Complexity: O(n^2)
     */
    public static boolean findAnagram2(String first, String second){

        char[] chars1 =first.toCharArray();
        char[] chars2 =second.toCharArray();


        for (char char1 : chars1){
            boolean found= false;
            for (int i=0 ;i<chars2.length; i++){

                char char2 = chars2[i];
                if(char1==char2){
                    chars2[i]= ' ';//To prevent duplication.
                    found =true;
                    break;
                }
            }
            if (found ==false) return false;
        }
        return true;
    }

    /**
     * Time Complexity: O(n*log n)
     */
    public static boolean findAnagram3(String first, String second){

        char[] chars1 =first.toCharArray();
        char[] chars2 =second.toCharArray();
        quicksort(chars1);
        quicksort(chars2);
        return chars1.toString().equals(chars2.toString());
    }

    public static void quicksort(char[] chars){
        //QuickSort a given array of characters.
    }

    public static void main(String[] args){
        System.out.println("Removed number of chars is "+ findAnagram("apple","awesome"));
    }
}
