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
        Participant participant = new Participant(57, 67);
        LinkedList<Participant> nerds = nerdOrNot.addParticipant(currentNerds, participant);

        // Then
        assertThat(nerds).hasSize(2);
        assertThat(nerds.peekFirst()).isEqualTo(participant);
    }

    @Test
    public void addParticipant_whenParticipantIsNotDominatedButDoesDominateSomeElse_thenParticipantIsAddedAndRemoveSomeElse() {
        // Given
        LinkedList<Participant> currentNerds = new LinkedList<>();
        Participant nerdToBeDominatedByParticipant = new Participant(57, 67);
        currentNerds.add(nerdToBeDominatedByParticipant);
        currentNerds.add(new Participant(72, 50));

        Participant participant = new Participant(74, 55);

        // When
        LinkedList<Participant> nerds = nerdOrNot.addParticipant(currentNerds, participant);

        // Then
        assertThat(nerds).hasSize(2);
        assertThat(nerds.peekLast()).isEqualTo(participant);
    }

    @Test
    public void addParticipant_whenParticipantIsNotDominatedAndNotDominatingSomeElse_thenParticipantIsAdded() {
        // Given
        LinkedList<Participant> currentNerds = new LinkedList<>();
        currentNerds.add(new Participant(57, 67));
        currentNerds.add(new Participant(74, 55));

        // When
        LinkedList<Participant> nerds = nerdOrNot.addParticipant(currentNerds, new Participant(64, 60));

        // Then
        assertThat(nerds).hasSize(3);
    }
}