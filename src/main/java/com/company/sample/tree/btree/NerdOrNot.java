package com.company.sample.tree.btree;

import java.util.Iterator;
import java.util.LinkedList;

public class NerdOrNot {

    public LinkedList<Participant> addParticipant(LinkedList<Participant> nerds, Participant participant) {
        if (nerds.size() == 0) {
            nerds.add(participant);
            return nerds;
        }
        Iterator<Participant> iterator = nerds.iterator();
        while (iterator.hasNext()) {
            Participant nerd = iterator.next();
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
            if (!iterator.hasNext()) {
                nerds.addLast(participant);
            }
        }
        return nerds;
    }
}
