package com.company.stack;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MinStackImplementationTest {

    @Test
    public void getMin_whenMinStackContainsOneNumber_thenReturningTheValue() {
        // Given
        MinStack minStackImplementation = new MinStackImplementation();
        int theOnlyOneNumber = 1;
        minStackImplementation.push(theOnlyOneNumber);

        // When
        int min = minStackImplementation.getMin();

        // Then
        Assertions.assertThat(min).isEqualTo(theOnlyOneNumber);
    }

}