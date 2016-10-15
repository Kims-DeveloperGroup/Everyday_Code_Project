package com.company.sample;

import java.util.PriorityQueue;

/**
 * Created by devoo-kim on 16. 10. 8.
 */
public class PriorityQueueSample {

    public static void main(String[] args){
        ComparatorSample cs1 = new ComparatorSample(1,4);
        ComparatorSample cs2 = new ComparatorSample(2,3);
        ComparatorSample cs3 = new ComparatorSample(3,2);
        ComparatorSample cs4 = new ComparatorSample(4,1);
        ComparatorSample[] descend = {cs1, cs2, cs3, cs4};
        ComparatorSample[] ascend = {cs4, cs3, cs2, cs1};
        PriorityQueue<ComparatorSample> pq = new PriorityQueue<>(4, cs1);
        for (ComparatorSample el : descend)
            pq.add(el);

        while (!pq.isEmpty()){
            ComparatorSample top = pq.poll();
            System.out.println("id: "+top.id+" value: "+top.value);
        }


    }
}
