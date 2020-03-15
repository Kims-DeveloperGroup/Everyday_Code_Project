package com.company.sample.tree.btree;

import java.util.LinkedList;

public class NerdOrNot {

    public LinkedList<Participant> addParticipant(LinkedList<Participant> nerds, Participant participant) {
        if (nerds.size() == 0) {
            nerds.add(participant);
            return nerds;
        }

        for (Participant nerd : nerds) {
            if (nerd.solvedProblems < participant.solvedProblems) {
                if (nerd.eatenRamens < participant.eatenRamens) {
                    nerds.removeFirst();
                }
            } else {
                if (nerd.eatenRamens > participant.eatenRamens) {
                    break;
                }
                nerds.addFirst(participant);
                break;
            }
        }
        return nerds;
    }
}
