package com.company.text;

import org.junit.jupiter.api.Test;

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
}