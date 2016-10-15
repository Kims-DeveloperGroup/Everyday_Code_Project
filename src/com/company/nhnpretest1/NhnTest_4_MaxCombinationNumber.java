package com.company.nhnpretest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Level of Difficulty: Low-intermediate
 *
 * @Problem : Given a set of strings in number format, combine a set of strings in order to make biggest number.
 *
 * @Condition: each number is smaller than 100
 *
 * @Solution by Full Search:
 * 1) Search and count every possible case recursively.
 * 2) add a value to tale of built value, which is returned as a maximum value from a callee.
 * 3) And return maximum combination of value to caller.
 *
 */
public class NhnTest_4_MaxCombinationNumber {

    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        int[] numbers;
        String[] numStrList;
        boolean[] used;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            numStrList = input.split(" ");
            for (String numStr : numStrList) {
                numberList.add(Integer.parseInt(numStr));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        used = new boolean[numberList.size()];
        Arrays.fill(used, false);
        System.out.print(combine(numberList, used)+"\n\n");
        System.out.print(combine2(numberList));
    }

    /**
     *Correct Answer, but not efficient (Brute-force)
     * Solved by full search
     */
    public static int combine(ArrayList<Integer> numbers, boolean[] used){
        int max=0;
        int num;
        int num2;

        for (int i=0; i< numbers.size(); i++){
            if (used[i]) continue;

            used[i] =true;
            num = numbers.get(i);
            num2= combine(numbers, used);

            if( 100>num && num>=10){
                num = num2*100+ num;
            }else if( 10>num) num = num2*10+ num;    // num2 (14)+ num(10)  => 1410

            max = Math.max(max,num);
            used[i] =false;
        }
        return max;
    }

    /**
     * Wrong Solution.
     * Can't be solved by Simple Greedy
     *
     * {15, 9}  15 is bigger than 9, but 951 is bigger than 159
     */

    public static int combine2(ArrayList<Integer> numbers){
        int lessThan =100;
        int resultNum=0;
        int max,num, temp;

        for (int i=0; i <numbers.size(); i++){ //Selection Sort used.
            max =numbers.get(i);
            for (int j=i+1; j <numbers.size(); j++){
                num = numbers.get(j);
                if (num> max){
                    numbers.set(j, max);
                    max=num;
                    numbers.set(i, num);
                }
            }
            if (100>max && max>=10) resultNum =resultNum*100+ max;
            else if(10 > max) resultNum = resultNum*10 +max;
        }
        return resultNum;
    }
}
