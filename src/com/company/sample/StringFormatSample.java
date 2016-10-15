package com.company.sample;

/**
 * Created by devoo-kim on 16. 10. 6.
 */
public class StringFormatSample {
    public static void main(String[] args){
        int input =3;
        for(int i=1; i<10 ; i++ ){
            System.out.printf("%1$d x %2$d = %3$d \n", input, i, i*input);
        }
    }//
}
