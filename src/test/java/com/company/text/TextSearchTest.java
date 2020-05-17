package com.company.text;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TextSearchTest {
    @Test
    public void searchText_whenSearchingAVAInAVAVA_thenReturning2() {
        // Given
        String textToSearch = "ava";
        TextSearch avava = new TextSearch("avava");

        // When
        int count = avava.searchText(textToSearch);

        // Then
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void buildIncrementMap_whenAAIsGiven_thenIncrementHasNoElement() {
        // Given
        String textToSearch = "aa";
        TextSearch avava = new TextSearch("avava");

        // When
        Map<Integer, Integer> aaIncrementMap = avava.buildIncrementMap(textToSearch);

        // Then
        assertThat(aaIncrementMap).hasSize(0);
    }

    @Test
    public void buildIncrementMap_when_ABcAB_IsGiven() {
        // Given
        String textToSearch = "abcabd";
        TextSearch avava = new TextSearch("avava");

        // When
        Map<Integer, Integer> aaIncrementMap = avava.buildIncrementMap(textToSearch);

        // Then
        assertThat(aaIncrementMap).hasSize(4);
        assertThat(aaIncrementMap.get(2)).isEqualTo(1);
        assertThat(aaIncrementMap.get(3)).isEqualTo(1);
        assertThat(aaIncrementMap.get(4)).isEqualTo(3);
        assertThat(aaIncrementMap.get(5)).isEqualTo(3);
    }

    @Test
    public void searchText_when_ABcAB_IsGiven() {
        // Given
        String textToSearch = "abcabd";
        TextSearch avava = new TextSearch("XXXX" + textToSearch + "XXXX" + textToSearch);

        // When
        int matchedCount = avava.searchText(textToSearch);

        // Then
        assertThat(matchedCount).isEqualTo(2);
    }
}