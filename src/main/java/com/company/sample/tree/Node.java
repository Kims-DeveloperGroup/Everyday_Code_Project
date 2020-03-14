package com.company.sample.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Node {
    boolean isRoot = false;

    public Node(String value) {
        this.value = value;
    }

    public int numericValue;

    public int depth = 0;

    public List<Node> children = new LinkedList<>();
    public String value;

    public Node(int numericValue) {
        this.numericValue = numericValue;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public void addChildren(Node... values) {
        children.addAll(Arrays.asList(values));
    }
}
