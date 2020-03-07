package com.company.problem.intermediate;

import javax.sound.sampled.Port;
import java.util.Arrays;

/**
 * @Level Of Difficulty : medium-intermediate Level
 *
 * @Problem: Find the best portfolio to invest for Three companies.
 *
 * @Condition:
 * 1. 아래와 같이 투자금액 대비 이익금을 임의로 생성하시오.
 * 2. 투자금 보다 이익금이 더 작을 수는 없음.
 * 3. 이익금은 투자금의 5배까지 가능함.
 *
 * @Solution:
 * 1. Consider a number of cases in sequential order from Company A to Company C.
 *              and Solve the sub-problem recursively.
 * 2. SubProblem : Get Max Profit of Portfolio. and Record an amount of investment for each company.
 * NOTE: Select appropriate data structure to store record, which is Very Very Important.
 */

public class Investor {

    static int[][] profitList = new int [3][201];
    static int[] bestPortfolio = new int[3];
    static int[] currPortfolio = new int[3];
    static int maxProfit=0;


    /** Correct Answer
     *
     * @param company: a Company to invest
     * @param balance: available amount of balance to invest
     * @return maximum amount of investment
     *
     */


    public static int[] findMaxProfit3(int company, int balance){
        int FLAG_PROFIT =3;
        int[] bestSet ={0,0,0,0}; //Save Best Portfolio at the current level
        int[] tempSet;

        if (company ==2){
            bestSet[company] = balance;
            bestSet[FLAG_PROFIT] = profitList[company][balance];
            return bestSet;
        }

        for (int money=0; money <= balance ; money++){
            tempSet = findMaxProfit2(company+1, balance-money); //Returned Update Status for the next companies exclusively to this company.
            tempSet[FLAG_PROFIT] += profitList[company][money];  //Sum this company and the next companies.
            tempSet[company] = money;
            if (tempSet[FLAG_PROFIT] > bestSet[FLAG_PROFIT]){   //Compare amount of profit at this level
                bestSet =tempSet;
            }
        }

        if (company==0){
            System.out.println(" findMaxProfit3() ");
            System.out.println("A: " + bestSet[0] +" "+ profitList[0][bestSet[0]]);
            System.out.println("B: " + bestSet[1] +" "+ profitList[1][bestSet[1]]);
            System.out.println("C: " + bestSet[2] +" "+ profitList[2][bestSet[2]]);
            System.out.println("최대 이익: " +bestSet[FLAG_PROFIT] +"만원\n");
        }
        return bestSet;
    }


    /** Wrong Answer : Didn't consider an amount of investment for this company when setting a data of max profit.
     *
     * @param company: a Company to invest
     * @param balance: available amount of balance to invest
     * @return maximum amount of investment
     *
     */

    public static int[] findMaxProfit2(int company, int balance){
        int FLAG_PROFIT =3;
        int[] bestSet ={0,0,0,0}; //Save Best Portfolio at the current level
        int[] tempSet;

        if (company ==2){
            bestSet[company] = balance;
            bestSet[FLAG_PROFIT] = profitList[company][balance];
            return bestSet;
        }

        for (int money=0; money <= balance ; money++){
            tempSet = findMaxProfit2(company+1, balance-money); //Returned Update Status for the next companies exclusively to this company.
            if (tempSet[FLAG_PROFIT] > bestSet[FLAG_PROFIT]){ //Compare amount of profit exclusively to this company.
                bestSet =tempSet;
                bestSet[company]=money;// Record optimum amount of money to invest for this company.
            }
        }
        bestSet[FLAG_PROFIT] += profitList[company][ bestSet[company] ];
        if (company==0){
            System.out.println(" findMaxProfit2() ");
            System.out.println("A: " + bestSet[0] +" "+ profitList[0][bestSet[0]]);
            System.out.println("B: " + bestSet[1] +" "+ profitList[1][bestSet[1]]);
            System.out.println("C: " + bestSet[2] +" "+ profitList[2][bestSet[2]]);
            System.out.println("최대 이익: " +bestSet[FLAG_PROFIT] +"만원\n");
        }
        return bestSet;
    }



    /**Wrong Answer
     *
     * @param company: a Company to invest
     * @param balance: available amount of balance to invest
     * @return maximum amount of investment
     *
     */
    public static int findMaxProfit(int company, int balance){

        if (company==2){
            //cache portfolio
            maxProfit = profitList[company][balance];
            return maxProfit;
        }

        for (int money=0; money<=balance; money++){
            int currProfit=profitList[company][money]+findMaxProfit(company+1, balance-money);
            //update maxProfit
            if(currProfit>maxProfit){
                maxProfit=currProfit;
                if(company==1){
                    currPortfolio[1]=money;
                    currPortfolio[2]=balance-money;
                }else if (company==0){
                    bestPortfolio[1]=currPortfolio[1];
                    bestPortfolio[2]=currPortfolio[2];
                    bestPortfolio[0]=money;
                }
            }
        }
        if (company==0){
            System.out.println(" findMaxProfit1() ");
            System.out.println("A: " + bestPortfolio[0] +" "+ profitList[0][bestPortfolio[0]]);
            System.out.println("B: " + bestPortfolio[1] +" "+ profitList[1][bestPortfolio[1]]);
            System.out.println("C: " + bestPortfolio[2] +" "+ profitList[2][bestPortfolio[2]]);
            System.out.println("최대 이익: " +maxProfit +"만원\n");
        }
        return maxProfit;
    }


    public static void setProfits(){
        for(int i=0; i<=200; i++){ //Make Random set of Portfolio
            profitList[0][i]=(int) (i* (1 + (Math.random()*4))); //Company(0)  [5.0 >Rate >1.0]
            profitList[1][i]=(int) (i* (1 + (Math.random()*4))); //Company(1)
            profitList[2][i]=(int) (i* (1 + (Math.random()*4))); //Company(2)
        }
    }

    public static void main(String[] args){
        setProfits();
        findMaxProfit2(0, 200);
        findMaxProfit3(0, 200);
    }









}


