package com.company.sample.graph;

import java.util.Arrays;

/**
 * Created by devoo-kim on 16. 11. 16.
 */
public class PrimsAlgorithm {

    boolean[][] adjacent =new boolean[10][10];
    boolean[] isSafe = new boolean[10]; //Initialize with true
    int[][] weight = new int[10][10];
    int[] distances= new int[10];
    int[] path = new int[10];
    int[] minQ =new int[10];
    int lenOfQ =0;

    public void initialize(){
        //Set values of adjacent
        //Set values of weight of edges
        Arrays.fill(distances, -1);
        Arrays.fill(isSafe, true);
        Arrays.fill(path, -1);
    }

    public void compute(int begin){
        initialize();
        distances[begin] =0;
        enqueueToMinQueue(begin);

        while (!isEmpty()) {
            int curr = dequeueFromMinQueue();
            isSafe[curr] = false;
            for (int i = 0; i < adjacent[curr].length; i++) {
                int adj = i;
                if (adjacent[curr][adj] == false) continue;

                int distance = distances[curr] + weight[curr][i];

                if (distances[adj] == -1){
                    distances[adj] = distance;
                    path[adj] = curr;
                    enqueueToMinQueue(adj);

                }else if (distances[adj]!= -1 && distance < distances[adj]) {

                    if (isSafe[adj]) continue;
                    distances[adj] = distance;
                    path[i] = curr;
                    updateMinQueue(adj);
                }
            }
        }
    }

    public void updateMinQueue(int vector){
        int update=0;
        for (int i=0; i<=lenOfQ; i++){
            if (minQ[i]== vector){
                update =i;
            }
        }

        int parent =update/2;
        while (update>1 &&
                distances[minQ[parent]] > distances[minQ[update]]){
            int temp = minQ[parent];
            minQ[parent] = minQ[update];
            minQ[update] = minQ[parent];
            update=parent;
            parent =update/2;
        }
    }

    public void enqueueToMinQueue(int vector){

        minQ[++lenOfQ]= vector;
        int parent=lenOfQ/2;

        while (parent>0) {
            minHeapify(parent);
            --parent;
        }
    }

    public int dequeueFromMinQueue(){
        int min= minQ[1];
        minQ[1] = minQ[lenOfQ];
        minQ[lenOfQ] =-1;
        --lenOfQ;
        minHeapify(1);
        return min;
    }

    public void minHeapify(int index){
        int curr =index;

        int smallest =0;
        int left = curr*2;
        int right =curr*2+1;

        if (distances[minQ[curr]] > distances[minQ[left]]) smallest =left;
        if (distances[minQ[curr]] > distances[minQ[right]]) smallest =right;

        if (smallest !=curr){
            int temp = minQ[curr];
            minQ[curr] = minQ[smallest];
            minQ[smallest] = minQ[curr];
            minHeapify(smallest);
        }
    }


    public boolean isEmpty(){
        return (lenOfQ<1);
    }
}
