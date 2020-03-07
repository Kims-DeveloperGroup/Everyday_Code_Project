package com.company.problem.intermediate;

/**
 * @Level Of Difficulty : Low Level
 *
 * @Problem: Evaluate a pair of names, each character of name will be evaluated by counting the stroke of it.
 *
 * @Solution: Initialize an array containing the number of strokes of given pair of names.
 *              and Sum it repeatedly.
 */
public class EvaluateCoupleNames {

    public int evaluate(String name1, String name2){
        String longer; //longer length of name between two given names.
        String shorter;

        if (name1.length()>name2.length()){
            longer= name1;
            shorter= name2;
        }else {
            longer =name2;
            shorter = name1;
        }

        int[] values = new int[name1.length() + name2.length()];
        int j=0, l=0, s=0;

        while (j < longer.length()+shorter.length()-1){// Initialize an array containing the count of each char's strokes.
            if (l<longer.length()) values[j++]= countStroke(longer.charAt(l++));
            if (s<shorter.length()) values[j++]= countStroke(shorter.charAt(s++));
        }
        //Sum two of adjacent elements repeatedly.
        int length = values.length-1;
        while (length>0) {
            for (int i = 0; i < length; i++) {
                values[i] =values[i]+ values[i+1];
            }
            length--;
        }
        return values[0];
    }

    public int countStroke(char letter){
        int strokes =0;
        //Count the stroke of a given letter.
        return strokes;
    }

    public int evaluate2(int[] values){
        int len = values.length-1;
        while (len>0) {
            for (int i = 0; i < len; i += 2) {
                values[i] = values[i] + values[i + 1];
            }
            len--;
        }
        return values[0];
    }
}
