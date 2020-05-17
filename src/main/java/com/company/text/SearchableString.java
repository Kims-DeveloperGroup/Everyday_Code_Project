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
                System.out.println("matched in " + startIndex);
                startIndex++;
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
        HashMap<Integer, Integer> incrementMap = new HashMap<>();
        for (int startIndex = 1; startIndex < text.length(); startIndex++) {
            int matchedLength = startIndex + 1;
            for (int i = 0; i < text.length() - startIndex; i++) {
                char ch1 = text.charAt(i);
                char leftCutText = text.charAt(i + startIndex);

                if (ch1 == leftCutText) {
                    incrementMap.put(matchedLength, startIndex);
                    System.out.println("matched: " + matchedLength + " char:" + ch1 + " increment: " + startIndex);
                    matchedLength++;
                } else {
                    break;
                }
            }

            if (matchedLength == startIndex + 1) {
                incrementMap.put(matchedLength, 1);
                System.out.println("matched: " + matchedLength + " increment: 1");
            } else {
                startIndex = matchedLength;
            }
        }
        return incrementMap;
    }

    /**
     * @param string to check the max length of matching postfix and prefix
     * @return max length of matching postfix and prefix
     */
    private int getMaxLengthMatchingPrefixAndPostfix(String string) {
        int maxLengthMatchingPrefixAndPostfix = 0;
        for (int prefixLength = 1; prefixLength < string.length(); prefixLength++) {
            String pre = string.substring(0, prefixLength);
            String post = string.substring(string.length() - prefixLength);
            if (pre.equals(post)) {
                System.out.println("prefix: " + pre + " post: " + post + " matched in " + string);
                maxLengthMatchingPrefixAndPostfix = prefixLength;
            }
        }
        return maxLengthMatchingPrefixAndPostfix;
    }
}
