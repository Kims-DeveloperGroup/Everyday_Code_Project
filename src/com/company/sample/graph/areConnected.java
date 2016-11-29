package com.company.sample.graph;

import java.util.Stack;

/**
 * Created by devoo-kim on 16. 11. 29.
 */
public class areConnected {
    private class Node{
        Node[] adj;
        int name;
    }

    public boolean isConnected(Node curr, Node desitination,
                                    Stack<Node> stack, boolean[] visited){

        if (curr ==desitination){
            visited[curr.name] =true;
            return true;
        }

        stack.push(curr);
        visited[curr.name] = true;
        boolean connected= false;
        for (Node adj : curr.adj){
            if (visited[adj.name]==true) continue;
            connected =isConnected(adj, desitination, stack, visited);
            if (connected==true) return true;
        }
        stack.pop();
        return false;
    }
}
