package com.company.text;

public class TextSearch {
    private final String text;

    public TextSearch(String text) {
        this.text = text;
    }

    public int searchText(String textToSearch) {
        int count = 0;
        for (int startIndex = 0; startIndex < text.length() - textToSearch.length() + 1; startIndex++) {
            int matchedCharCount = 0;
            for (int currIndex = 0; currIndex < textToSearch.length(); currIndex++) {
                char ch1 = text.charAt(currIndex + startIndex);
                char ch2 = textToSearch.charAt(currIndex);
                if (ch1 != ch2) {
                    break;
                }
                matchedCharCount++;
            }
            if (matchedCharCount == textToSearch.length()) {
                count++;
            }
        }
        return count;
    }
}
