package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NhnIOtemplate {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            int integerInput = Integer.parseInt(input);
            System.out.println("Input Number is " + input);
            for (int i = 1; i < 10; i++) {
                System.out.println(integerInput + " x " + i + "=" + (integerInput * i));
            }
        } catch (Exception e) {}

        /**Sample Nhn IO Handle**/

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            int integerInput = Integer.parseInt(input);

        } catch (Exception e) {}
    }

}
