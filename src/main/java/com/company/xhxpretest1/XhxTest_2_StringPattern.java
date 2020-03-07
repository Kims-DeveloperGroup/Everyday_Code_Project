package com.company.xhxpretest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Level of Difficulty: Medium-intermediate
 *
 * Problem : Given set of words. and countStroke the number of words that contain two of patters. e.g)  vowels >=2 in a row or consonant >=3 in a row.
 *
 * Solution :
 * 1) Inspect each word by traversing char by char to find the pattern.
 * 2) Stop searching a word if 자음 pattern and 모음 pattern are both found.
 *
 * NOTE: Get an appropriate way of using 'OR' and 'NOT' operation.( e.g) ~~을 제외하는 모든것)
 */
public class XhxTest_2_StringPattern {


    public static void main(String[] args){
        String[] words = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");

        } catch (IOException e) {
            e.printStackTrace();
        }
        char ch1;
        int count_m=0;
        int count_j=0;
        int moeum=0;
        int jaeum=0;
        boolean find_M;
        boolean find_J;

        for (String word : words){
            find_J =false; //Don't countStroke if a pattern is counted already in the same word.
            find_M = false;

            for (int i=0 ; i<word.length()-1; i++){    //Traverse only one word
                ch1= word.charAt(i);
                moeum=0; jaeum=0;

                while (true){ //Searching from a char
                    int j=i+1;
                    char ch2 = word.charAt(j++);

                    //Revision point from main2(Wrong Answer: Incorrect OR operation)
                    if (ch1== 'a'|| ch1=='e' || ch1 =='i' || ch1=='o'|| ch1=='u'){
                        if (ch2 == 'a'|| ch2 =='e' || ch2 =='i' || ch2 =='o'|| ch2 =='u') moeum++;
                        else break;
                    }
                    if( ch1 != 'a' && ch1 !='e' && ch1 !='i' && ch1 !='o'&& ch1 !='u') {
                        if (ch2 != 'a'&& ch2 !='e' && ch2 !='i' && ch2 !='o'&& ch2 !='u') jaeum++;
                        else break;
                    }

                    if (moeum>=1 && !find_M){ //If the pattern is already found in the same word.
                        count_m++;
                        find_M =true;
                        break;
                    }else if(jaeum>=2 && !find_J){
                        count_j++;
                        find_J =true;
                        break;
                    }
                    if (j>= word.length()) break;
                }
                if(find_J && find_M) break;
            }
        }
        System.out.println(count_m);
        System.out.println(count_j);
    }

    /**
     *
     * @Mistake : Misunderstanding of 'OR' operation and 'NOT' operation.
     *
     * Should be careful with 'OR' and 'NOT' Operation.
     */

    public static void main2(String[] args) {
        String[] words = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");

        } catch (IOException e) {
            e.printStackTrace();
        }

        char ch1;
        int count_m=0;
        int count_j=0;
        int moeum=0;
        int jaeum=0;
        for (String word : words){

            for (int i=0 ; i<word.length()-1; i++){//Traverse only one word
                ch1= word.charAt(i);
                moeum=0; jaeum=0;

                while (true){ //Searching from a char
                    int j=i+1;
                    char ch2 = word.charAt(j++);


                    if (ch1== 'a'|| ch1=='e' || ch1 =='i' || ch1=='o'|| ch1=='u'){
                        if (ch2 == 'a'|| ch2 =='e' || ch2 =='i' || ch2 =='o'|| ch2 =='u') moeum++;
                        else break;
                    }
                    /***Critical Mistake Point(Incorrect useage of 'OR' and "NOT operation)***/
                    /**Intention was if ch1 is not 모음. But it's wrong. check comment below **/
                    if( ch1 != 'a'|| ch1 !='e' || ch1 !='i' || ch1 !='o'|| ch1 !='u') { /**Even if ch1 is 'e'(자음), ch1 is considered as 자음 **/
                        if (ch2 == 'i'|| ch2 =='e' || ch2 =='a' || ch2 =='o'|| ch2 =='u') break;
                         jaeum++;
                    }

                    if (moeum>=1){
                        count_m++;
                        break;
                    }else if(jaeum>=2){
                        count_j++;
                        break;
                    }
                    if (j>= word.length()) break;
                }
            }
        }
        System.out.println(count_m);
        System.out.println(count_j);
    }



}
