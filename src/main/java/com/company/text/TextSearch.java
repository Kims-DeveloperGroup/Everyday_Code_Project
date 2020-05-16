package com.company.text;

import java.util.HashMap;
import java.util.Map;

public class TextSearch {
    private final String text;

    public TextSearch(String text) {
        this.text = text;
    }

    public int searchText(String textToSearch) {
        Map<Integer, Integer> incrementByMatchedPostfix = buildCache(textToSearch);
        int count = 0;
        for (int startIndex = 0; startIndex < text.length() - textToSearch.length() + 1; ) {
            int matchedCharCount = 0;
            for (int currIndex = textToSearch.length() - 1; currIndex >= 0; ) {
                char ch1 = text.charAt(currIndex + startIndex);
                char ch2 = textToSearch.charAt(currIndex);
                if (ch1 != ch2) {
                    break;
                }
                matchedCharCount++;
                currIndex--;
            }
            if (matchedCharCount == textToSearch.length()) {
                count++;
            }
            startIndex = startIndex + incrementByMatchedPostfix.get(matchedCharCount);
        }
        return count;
    }

    public Map<Integer, Integer> buildCache(String text) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(text.length(), 1);
        for (int len = 1; len < text.length(); len++) {
            int matched = 0;
            for (int i = 0; i < len; i++) {
                char pre = text.charAt(i);
                char post = text.charAt(text.length() - 1 - i);

                if (post == pre) {
                    matched++;
                }
            }
            if (len == matched) {
                map.put(len, text.length() - len);
            } else {
                map.put(len, 1);
            }
        }
        return map;
    }
}
