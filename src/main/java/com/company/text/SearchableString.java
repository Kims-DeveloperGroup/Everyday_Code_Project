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

    private int getMaxLengthMatchingPrefixAndPostfix(String subStr) {
        System.out.println("subString: " + subStr);
        int maxLength = 0;
        for (int prefixLength = 1; prefixLength < subStr.length(); prefixLength++) {
            String pre = subStr.substring(0, prefixLength);
            String post = subStr.substring(subStr.length() - prefixLength);
            System.out.println("pre: " + pre + " post: " + post + " prefixLen: " + prefixLength);
            if (pre.equals(post)) {
                System.out.println("matched");
                maxLength = prefixLength;
            }
        }
        return maxLength;
    }
}
