package com.company.nhnpretest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Level of Difficulty : low
 *
 * @Problem: Given a set of one dimension coordinates e.g) 6 30 21 8 38 40, Find a pairs of two coordinate close one another.
 * But if more than two pairs exist, choose smaller sum of two coordinate. e.g) (6,8) or (38,40)  but choose (6,8)
 *
 * @Solution by Full Search:
 * 1) set a compare value and fully count difference with others.
 * 2) compare with current value of minimum difference. If this difference is smaller than the min value, update it.
 * 3) Store a pair of values in the array to record what are closest pairs and what has smallest sum of values.
 */
public class NhnTest_1_ClosestCoordinates_ {

    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            String[] numStrList = input.split(" ");
            for (String numStr : numStrList) {
                numberList.add(Integer.parseInt(numStr));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] pair = new int[2];
        int min=0;

        for (Integer number : numberList) {

            for (Integer number2 : numberList){
                if(number==number2) continue;
                if (Math.abs(number- number2)<= min || min ==0){
                    if (pair!=null && min== Math.abs(number- number2)
                            && pair[0]+pair[1]<= number+number2)continue;
                    else{
                        min = Math.abs(number- number2);
                        pair[0] =number;
                        pair[1]= number2;
                    }
                }
            }
        }
        System.out.println(pair[0]+" "+pair[1]);

        // 다음과 같은 방식으로 numberList와 number 변수를 사용할 수 있음
        /*
        for (Integer number : numberList) {
            System.out.println("number=" + number);
        }
        */

    }
}
