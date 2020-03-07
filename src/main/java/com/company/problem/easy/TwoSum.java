package com.company.problem.easy;


/**
 * @Level Of Difficulty : Medium-Low Level  : Optimization for time limit
 *
 * @Problem: Find any of tuple(indices), which sums a given data in an array with distinct elements.
 *
 * @Solution: Search in a brutal-force way. For optimization and removing duplicate calculation,
 * Use heuristic algorithm. Or use cache(Dynamic Programming) if Enough size of memory is offered.
 */
public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
//        boolean[][] caculated = new boolean[list.length][list.length]; (Out of Memory)
//        for (boolean[] row: caculated )
//            Arrays.fill(row, false);
        //Heuristic : Make a border to skip searching point.
        int min =0;
        int max =0;
        for(int num : list){
            min =Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] result = new int[2];

        for (int value1 =0 ; value1 < list.length; value1++){
            if(list[value1] > sum ||
                    list[value1]+min >sum || list[value1]+ max<sum) continue; //**Optimization Point (Heuristic): Largely reduce the running time

            for (int value2 =0; value2< list.length; value2++){
//                if(caculated[value1][value2]) continue; //Optimization Point(Out of Memory)
//                caculated[value1][value2] =true; (Out of Memory)
                if(list[value2] > sum) continue; //Optimization Point
                if (value1 ==value2) continue; //Optimization Point

                if(list[value1]+list[value2] == sum){
                    result[0]= value1;
                    result[1]= value2;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 16);
        System.out.println(indices[0] + " " + indices[1]);
    }
}
