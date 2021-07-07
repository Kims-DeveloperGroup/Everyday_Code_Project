package com.company.problem.hard;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BalancingElementsTest {
    private final BalancingElements balancingElements = new BalancingElements();

    @Test
    public void test55258_thenReturning2() {
        // Given
        int[] unbalancedElements = new int[]{5, 5, 2, 5, 8};

        // When
        int balancingElementsCount = balancingElements.countBalancingElemetns(unbalancedElements);

        // Then
        assertThat(balancingElementsCount).isEqualTo(2);
    }
}