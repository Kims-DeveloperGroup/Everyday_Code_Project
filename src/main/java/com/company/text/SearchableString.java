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
        System.out.println("start to search");
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int partialLength = 2; partialLength < text.length(); partialLength++) {
            String partialString = text.substring(0, partialLength);
            int maxLengthToMatch = getMaxLengthMatchingPrefixAndPostfix(partialString);
            if (maxLengthToMatch == 0) {
                map.put(partialLength, 1);
            } else {
                map.put(partialLength, partialLength - maxLengthToMatch);
            }
        }
        return map;
    }

    /**
     * @param string to check the max length of matching postfix and prefix
     * @return max length of matching postfix and prefix
     */
    private int getMaxLengthMatchingPrefixAndPostfix(String string) {
        System.out.println("subString: " + string);
        int maxLengthMatchingPrefixAndPostfix = 0;
        for (int prefixLength = 1; prefixLength < string.length(); prefixLength++) {
            String pre = string.substring(0, prefixLength);
            String post = string.substring(string.length() - prefixLength);
            System.out.println("pre: " + pre + " post: " + post + " prefixLen: " + prefixLength);
            if (pre.equals(post)) {
                System.out.println("matched");
                maxLengthMatchingPrefixAndPostfix = prefixLength;
            }
        }
        return maxLengthMatchingPrefixAndPostfix;
    }
}
