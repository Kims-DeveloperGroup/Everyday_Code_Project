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
            int matchedLength = startIndex + 1;
            for (int i = 0; i < text.length() - startIndex; i++) {
                char ch1 = text.charAt(i);
                char leftCutText = text.charAt(i + startIndex);

                if (ch1 == leftCutText) {
                    incrementMap.put(matchedLength, startIndex);
                    System.out.println("matchedLength: " + matchedLength + " increment: " + startIndex);
                    matchedLength++;
                } else {
                    incrementMap.put(matchedLength, 1);
                    System.out.println("matchedLength: " + matchedLength + " increment: " + 1);
                    break;
                }
            }
            startIndex = matchedLength;
        }
        System.out.println("IncrementMap has been built.");
        return incrementMap;
    }
}
