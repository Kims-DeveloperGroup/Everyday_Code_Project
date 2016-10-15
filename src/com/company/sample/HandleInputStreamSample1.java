package com.company.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by devoo-kim on 16. 10. 6.
 */
public class HandleInputStreamSample1 {

    public static void main(String[] args) {
        String[] words = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 다음과 같은 방식으로 words와 word 변수를 사용할 수 있음
        /*
        for (String word : words) {

        }

        */

        // write your code here



    }
}
