package com.company.sample.lambda;

import com.sun.tools.javac.util.StringUtils;

import java.util.function.UnaryOperator;

/**
 * Created by rikim on 2017. 9. 2..
 */
public class MethodParameter {

    public static void method(String input, UnaryOperator<String> function) {
        String result = function.apply(input);
        System.out.println(input + " has changed to " + result);
    }

    public static void main(String[] args) {
        MethodParameter.method("TIGER", input -> {
            String output = StringUtils.toLowerCase(input);
            return output;
        });
        MethodParameter.method("TIGER", input -> StringUtils.toLowerCase(input));

        MethodParameter.method("TIGER", StringUtils::toLowerCase);
    }
}
