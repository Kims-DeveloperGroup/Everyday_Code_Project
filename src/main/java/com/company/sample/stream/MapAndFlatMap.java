package com.company.sample.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by rikim on 2017. 9. 2..
 */
public class MapAndFlatMap {

    private static void mapCharactor(String[] words) {
        Arrays.stream(words).map(word -> {
            List<Character> chars = new ArrayList<>();
            for (char ch : word.toCharArray()) {
                chars.add(ch);
            }
            return chars.stream();
        }).forEach(stream -> {
            System.out.println("Map Stream In");
            stream.forEach(character -> System.out.print(character));
            System.out.println("\nMap Stream Out");
        });
    }

    private static void flatmapCharactor(String[] words) {
        Arrays.stream(words).flatMap(word -> {
            List<Character> chars = new ArrayList<>();
            for (char ch : word.toCharArray()) {
                chars.add(ch);
            }
            return chars.stream();
        }).forEach(ch -> {
                System.out.print(ch);
        });
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana"};
        MapAndFlatMap.mapCharactor(words);
        MapAndFlatMap.flatmapCharactor(words);
    }
}
