package com.company.sample.tree;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public Node(String value) {
        this.value = value;
    }

    public List<Node> children = new LinkedList<>();
    public String value;

    public void addChild(Node child) {
        children.add(child);
    }

    public void addChildren(String ...values) {
        for (String value : values) {
            addChild(new Node(value));
        }
    }
}
