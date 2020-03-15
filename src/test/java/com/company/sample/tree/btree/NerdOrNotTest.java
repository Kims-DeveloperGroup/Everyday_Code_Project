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
}