package com.company.sample;

/**
 * Created by devoo-kim on 16. 10. 6.
 */
public class StringSplitSample {
    public static void main(String[] args){
       String str ="3 4 5 6 7";
       String[] splitStrs= str.split(" ");
        int i =0;
        for (String aStr: splitStrs){
            System.out.printf("%2$d 번째 String은 %1$s 입니다.\n",aStr, i++);
        }
    }//
}
