package com.company.sample.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by rikim on 2017. 9. 3..
 */
public class Reduce {

    public static void main(String[] args) {
        Integer[] numbgers = {1, 2, 3};
        System.out.println(Reducer.reduce(numbgers));
    }

    private static class Reducer {
        public static int reduce(Integer[] numbgers) {
            Stream<Integer> stream = Stream.of(numbgers);
            Optional<Integer> sum = stream.reduce((integer, integer2) -> integer2 + integer);
            return sum.orElse(-1);
        }
    }
}
