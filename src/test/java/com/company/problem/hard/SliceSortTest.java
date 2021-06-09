package com.company.problem.hard;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class SliceSortTest {
    public SliceSort sliceSort = new SliceSort();

    @Test
    public void sample1() {
        // Given
        Integer[] given = {2, 4, 1, 6, 5, 9, 7};

        // When
        int slicedCount = sliceSort.sort(given);

        // Then
        Assertions.assertEquals(3, slicedCount);
    }

    @Test
    public void sample2() {
        // Given
        Integer[] given = {4, 3, 2, 6, 1};

        // When
        int slicedCount = sliceSort.sort(given);

        // Then
        Assertions.assertEquals(1, slicedCount);
    }

    @Test
    public void sample3() {
        // Given
        Integer[] given = {2, 1, 6, 4, 3, 7};

        // When
        int slicedCount = sliceSort.sort(given);

        // Then
        Assertions.assertEquals(3, slicedCount);
    }
}
