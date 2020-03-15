package com.company.sample.tree.btree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

class NerdOrNotTest {
    public NerdOrNot nerdOrNot = new NerdOrNot();

    @Test
    public void addParticipant_whenNoNerdHasParticipatedYet_thenParticipantIsAdded() {
        // Given

        // When
        LinkedList<Participant> nerds = nerdOrNot.addParticipant(new LinkedList<>(), new Participant(50, 50));

        // Then
        assertThat(nerds).hasSize(1);
    }

    @Test
    public void addParticipant_whenParticipantIsNotDominatedAndDoesNotDominateSomeElse_thenParticipantIsAdded() {
        // Given
        LinkedList<Participant> currentNerds = new LinkedList<>();
        currentNerds.add(new Participant(72, 50));

        // When
        LinkedList<Participant> nerds = nerdOrNot.addParticipant(currentNerds, new Participant(57, 67));

        // Then
        assertThat(nerds).hasSize(2);
    }
}