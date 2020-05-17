package com.company.text;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchableStringTest {
    @Test
    public void searchText_whenSearchingAVAInAVAVA_thenReturning2() {
        // Given
        String textToSearch = "ava";
        SearchableString avava = new SearchableString("avava");

        // When
        int count = avava.searchText(textToSearch);

        // Then
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void buildIncrementMap_whenAAIsGiven_thenIncrementHasNoElement() {
        // Given
        String textToSearch = "aa";
        SearchableString avava = new SearchableString("avava");

        // When
        Map<Integer, Integer> aaIncrementMap = avava.buildIncrementMap(textToSearch);

        // Then
        assertThat(aaIncrementMap).hasSize(0);
    }

    @Test
    public void buildIncrementMap_when_ABcAB_IsGiven() {
        // Given
        String textToSearch = "abcabd";
        SearchableString searchableString = new SearchableString("");

        // When
        Map<Integer, Integer> incrementMap = searchableString.buildIncrementMap(textToSearch);

        // Then
        assertThat(incrementMap).hasSize(4);
        assertThat(incrementMap.get(2)).isEqualTo(1);
        assertThat(incrementMap.get(3)).isEqualTo(1);
        assertThat(incrementMap.get(4)).isEqualTo(3);
        assertThat(incrementMap.get(5)).isEqualTo(3);
    }

    @Test
    public void searchText_whenSearchableTextContainsTheGivenStringIn2SubString_thenReturning2() {
        // Given
        String textToSearch = "abcabd";
        SearchableString searchableString = new SearchableString("XXXX" + textToSearch + "XXXX" + textToSearch);

        // When
        int matchedCount = searchableString.searchText(textToSearch);

        // Then
        assertThat(matchedCount).isEqualTo(2);
    }
}