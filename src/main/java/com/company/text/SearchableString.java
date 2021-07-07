package com.company.text;

import java.util.HashMap;
import java.util.Map;

public class SearchableString {
    public final String text;
    public Map<Integer, Integer> integerIntegerMap;

    public SearchableString(String text) {
        this.text = text;
    }

    public int searchText(String textToSearch) {
        integerIntegerMap = this.buildIncrementMap(textToSearch);
        System.out.println("\nStart to search " + textToSearch + " in " + this.text);
        int count = 0;
        for (int startIndex = 0; startIndex < text.length() - textToSearch.length() + 1; ) {
            int matchedCharCount = 0;
            System.out.println("startIndex: " + startIndex);
            for (int currIndex = 0; currIndex < textToSearch.length(); ) {
                char ch1 = text.charAt(currIndex + startIndex);
                char ch2 = textToSearch.charAt(currIndex);
                if (ch1 != ch2) {
                    break;
                }
                matchedCharCount++;
                currIndex++;
            }
            if (matchedCharCount == textToSearch.length()) {
                count++;
                System.out.println("all matched in " + startIndex);
                startIndex = startIndex + this.integerIntegerMap.get(matchedCharCount);
            } else if (matchedCharCount == 0 || matchedCharCount == 1) {
                startIndex++;
            } else {
                startIndex = startIndex + this.integerIntegerMap.get(matchedCharCount);
            }
        }
        return count;
    }

    /**
     * Referencing KMP algorithm
     * Build a start-index-increment map when searching text
     * Key: length of first matching chars, Value: How many a start index increments.
     *
     * @param text to build
     * @return a start-index-increment map
     */
    Map<Integer, Integer> buildIncrementMap(String text) {
        System.out.println("IncrementMap build started for " + text);
        HashMap<Integer, Integer> incrementMap = new HashMap<>();
        for (int startIndex = 1; startIndex < text.length(); ) {
            int currentIndex = startIndex;
            for (; currentIndex < text.length(); currentIndex++) {
                char ch1 = text.charAt(currentIndex - startIndex);
                char leftCutText = text.charAt(currentIndex);
                int partialMatchingLength = currentIndex + 1;
                if (ch1 == leftCutText) {
                    incrementMap.put(partialMatchingLength, startIndex);
                    System.out.println("matchedLength: " + partialMatchingLength + " increment: " + startIndex);
                } else {
                    incrementMap.put(currentIndex + 1, 1);
                    System.out.println("matchedLength: " + partialMatchingLength + " increment: " + 1);
                    break;
                }
            }
            startIndex = currentIndex + 1;
        }
        System.out.println("IncrementMap has been built.");
        return incrementMap;
    }
}
