package com.company.sample.tree.btree;

import java.util.LinkedList;

public class NerdOrNot {

    public LinkedList<Participant> addParticipant(LinkedList<Participant> nerds, Participant participant) {
        if (nerds.size() == 0) {
            nerds.add(participant);
            return nerds;
        }
        return nerds;
    }
}
