/*
ii) Write a function that takes in a non-empty array of distinct integers and an 
integer representing a target sum. The function should find all triplets in the array 
that sum up to the target sum and return a two-dimensional array of all these triplets. 
The numbers in each triplet should be ordered in ascending order, and the triplets themselves 
should be ordered in ascending order with respect to the numbers they hold. If no three numbers sum up to the target sum, the function should return an empty array.
Ex:
target_sum = 6
nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]
result = [[1, 2, 3]]
 */

import java.util.ArrayList;
import java.util.Scanner;

class problem2{
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        ArrayUtils arrayObj = new ArrayUtils();
     
        // input array
        int[] nums = arrayObj.inputArray();
        arrayObj.sort(nums);
        int target = scn.nextInt();

        // triplet of target sum
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> sublist = new ArrayList<>();
        targetSumTriplets(nums, target, result, sublist, 0);

        for(ArrayList<Integer> triplets : result){
            System.out.print("( ");
            for(int i=0; i<triplets.size(); i++){
                System.out.print(triplets.get(i)+" ");
            }
            System.out.print(")");
            System.out.println("");
        }
    }

    public static void targetSumTriplets(int[] num, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> sublist, int i){
        if(i>=num.length) return;
        if(target == 0 && sublist.size() == 3){
            result.add(new ArrayList<>(sublist));
            return;
        }
        if(sublist.size() > 3) return;

        
            sublist.add(num[i]);
            targetSumTriplets(num, target - num[i], result, sublist, i+1);
            sublist.remove(sublist.size()-1);
            targetSumTriplets(num, target, result, sublist, i+1);

    } 
 }