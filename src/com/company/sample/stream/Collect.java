package com.company.sample.stream;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by rikim on 2017. 9. 3..
 */
public class Collect {

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Ricardo");
        names.add("Billie");
        names.add("Ian");
        names.add("David");
        Collector.joinWords(names);
        Collector.collectByAgeGroup(names);
        Collector.collect(names);
    }

    private static class Collector {
        public static void joinWords(Set<String> words) {
            String joinedString = words.stream().collect(Collectors.joining(", "));
            System.out.println(joinedString);
        }

        public static void collectByAgeGroup(Set<String> people) {
            Map<Integer, List<String>> groupedByAge = people.stream().collect(Collectors.groupingBy(name -> {
                if (name.equals("David")) {
                    return 40;
                } else {
                    return 30;
                }
            }));

            groupedByAge.forEach((ageGroup, names) -> {
                System.out.println(ageGroup + "대");
                names.forEach(name -> System.out.println(name));
            });
        }

        public static void collect(Set<String> people) {
            StringBuilder result1 = people.stream()
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
            System.out.println(result1.toString());

            StringBuilder result2 = people.stream().collect(StringBuilder::new, (builder, name)-> builder.append(name).append(", "),
                    StringBuilder::append);
            System.out.println(result2.toString());
        }
    }
}
