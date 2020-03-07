package com.company.xhxpretest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Level of Difficulty: Low-intermediate
 *
 * @Problem : 1) Make a number which is same as reverse number.
 * 2) If the number is not same as its reverse number, add reverse number to it. e.g) 145+ 541 =686, number becomse 686
 * 3) Repeating step 2 till find the answer. But the number should be less than 1000.
 *
 * @Condition: A given number is smaller than 1000.
 *
 * @Solution: A reverse number is computed in two cases, 2-digit or 3-digit number.
 */
public class XhxTest_3_ReverseNumber {
    public static void main(String[] args) {
        int number = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        findSameReverse1(number);
        System.out.println("===================================");
        findSameReverse2(number);

    }

    public static void findSameReverse1(int number){
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
        System.out.println("No answer.");
    }

    public static void findSameReverse2(int init){
        if (init<10) System.out.println(init+ " should be bigger than 9.");
        int number =init;
        int reverse;

        while (number<1000){

            if (number <100){
                reverse = (number%10*10) + (number/10);
            }else{
                reverse= (number%10*100)+ (number%100 - number%10) + (number/100);
            }

            if (reverse==number){
                System.out.println(number);
                return;
            }
            number +=reverse;
        }
        System.out.println(init +" has no answer.");
    }
}
