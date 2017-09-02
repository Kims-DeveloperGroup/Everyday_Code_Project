package com.company.sample.lambda;

import com.sun.tools.javac.util.StringUtils;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by rikim on 2017. 9. 2..
 */
public class MethodParameter {

    public static void methodUsingUnaryOperator(String input, UnaryOperator<String> function) {
        String result = function.apply(input);
        System.out.println(input + " has changed to " + result);
    }

    public static void methodUsingFunctionInterface(String input, Function<String, Integer> function) {
        Integer result = function.apply(input);
        System.out.println(input + " has length : " + result);
    }

    public static void methodUsingCustomMethod(String input, MyFunction<String, String> function) {
        String result = function.doAnything(input);
        System.out.println(input + " has become " + result);
    }

    public static void methodUsingCustomMethodDoingMore(String input, MyFunction<String, String> function) {
        String result = function.doMoreThanAnything(input);
        System.out.println(input + " has become " + result);
    }

    public static void main(String[] args) {
        String tigerStr = "TIGER";
        MethodParameter.methodUsingUnaryOperator(tigerStr, input -> {
            String output = StringUtils.toLowerCase(input);
            return output;
        });
        MethodParameter.methodUsingUnaryOperator(tigerStr, input -> StringUtils.toLowerCase(input));
        MethodParameter.methodUsingUnaryOperator(tigerStr, StringUtils::toLowerCase);

        MethodParameter.methodUsingFunctionInterface(tigerStr, input -> input.length());
        MethodParameter.methodUsingFunctionInterface(tigerStr, String::length);

        MethodParameter.methodUsingCustomMethod(tigerStr, input -> new StringBuilder(input).append("JK").toString());
        MethodParameter.methodUsingCustomMethodDoingMore(tigerStr, input -> new StringBuilder(input).append("JK").toString());
    }
}
