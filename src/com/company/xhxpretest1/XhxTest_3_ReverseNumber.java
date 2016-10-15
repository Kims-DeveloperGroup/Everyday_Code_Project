package com.company.nhnpretest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Level of Difficulty: Low-intermediate
 *
 * @Problem : 1) Make a number which is same as reverse number.
 * 2) If the number is not same as its reverse number, add reverse number to it. e.g) 145+ 541 =686, number becomse 686
 * 3) Repeating step 2 till find the answer. But the number should be less than 1000.
 */
public class NhnTest_3_ReverseNumber {
    public static void main(String[] args) {
        int number = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rev_num;
        int first, second, third;


        while (number<1000){
            first = number%10;
            second = number%100-first;
            third = number -second-first;

            if (number>=100) rev_num =first*100 + second+ third/100;
            else if(100>number&& number>=10) rev_num =second/10 +first*10;
            else rev_num =number;

            if (rev_num==number && number>=10) {
                System.out.println(rev_num);
                return;
            }else
                number = number+rev_num;
        }
        System.out.println("-1");
    }
}
