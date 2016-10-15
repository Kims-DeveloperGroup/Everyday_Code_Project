package com.company.sample;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by devoo-kim on 16. 10. 8.
 */
public class ComparatorSample implements Comparator<ComparatorSample> {
    int id;
    int value;

    public ComparatorSample(int id, int value){
        this.id =id;
        this.value =value;
    }

    @Override
    public int compare(ComparatorSample o1, ComparatorSample o2) {
        return o1.value -o2.value;
    }


    public static void main(String[] args){
        ComparatorSample cs1 = new ComparatorSample(1,4);
        ComparatorSample cs2 = new ComparatorSample(2,3);
        ComparatorSample cs3 = new ComparatorSample(3,2);
        ComparatorSample cs4 = new ComparatorSample(4,1);

        ComparatorSample[] unsorted = {cs1, cs2, cs3, cs4};
        System.out.println("Unsorted");
        for (ComparatorSample el : unsorted)
            System.out.println("id:"+ el.id +" value: "+ el.value);

        Arrays.sort(unsorted, cs1);
        System.out.println("Sorted");
        for (ComparatorSample el : unsorted)
            System.out.println("id:"+ el.id +" value: "+ el.value);
    }
}
