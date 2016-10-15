package com.company.problem.intermediate;

import java.util.Arrays;
/**
 * @Level Of Difficulty : Low-intermediate Level
 *
 * @Problem: Traverse a Two 2d matrix from the right corner of the bottom like a spiral.
 *
 * @Solution: 1.Continuously move to the current direction. When facing a visited position or outOfRange, Set a new Direction.
 * Node: Do not change the current direction. Change that only when facing a dead end(There should be only one position in four directions).
 * 2. Use a flag data set to the direction to data.
 * 3. Direction flag indicates to info to move (next).
 */

public class SpiralTraverse {

    public static void spiralTraverse(int height, int width){
        boolean[][] matrix = new boolean[height][width];//Flag: visited or not.

        int direction= -1; //Flag: a direction to keep moving
        int[][] next = { //Only Four Direction to move
                {0, -1}, //LEFT: direction(0)
                {0, +1}, //RIGHT direction(1)
                {+1, 0}, //DOWN direction(2)
                {-1, 0}  //UP direction(3)
        };
        for ( boolean[] row: matrix )
            Arrays.fill(row, false);

        int currY= matrix.length-1;
        int currX= matrix[0].length-1;
        int nextY;
        int nextX;
        int count =0;

        while(true){
            if(direction == -1) direction =0; //Point of Beginning
            matrix[currY][currX]=true; //Check visited
            ++count;
            System.out.printf("Current Position: (%d, %d)\n", currY, currX);
            nextY = currY + next[direction][0]; //Keep moving to the current direction
            nextX = currX + next[direction][1];
            if ((nextX< width && nextX>=0)&&(nextY>=0 && nextY<height)
                    && matrix[nextY][nextX]==false){ //If possible to keep the direction, move to the next without direction change.
                currY = nextY;
                currX = nextX;
            }else{
                //Impossible to keep the direction and Search a new direction.
                boolean foundNew =false;
                for (int i =0; i < next.length ; i++){
                    //Search an available Postion to move
                    nextY = currY + next[i][0];
                    nextX = currX + next[i][1];
                    if ((nextX< width && nextX>=0)&&(nextY>=0 && nextY<height)
                            && matrix[nextY][nextX]==false){//If find an available position in four directions,
                        foundNew =true;
                        direction =i; //Set a new Direction
                        currY = nextY;//Move to the next position
                        currX = nextX;
                        break;// Stop searching.
                    }
                }
                if(!foundNew){
                    //Stop Traversing if no position is available to move.
                    System.out.printf("Traverse is finished.\nFinal Position: (%d, %d)\n Count: %d\n",currY , currX, count);
                    return;
                }
            }

        }
    }

    public static void main(String[] args){
//        spiralTraverse(4,4);//OK
//        spiralTraverse(5,5);//OK
//        spiralTraverse(9,9);//OK
        spiralTraverse(11,11);
    }
}
