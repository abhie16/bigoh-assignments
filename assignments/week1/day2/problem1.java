/*

i)Write a program to remove duplicate values from an array and returns an array of unique values. int[] removeDuplicates(int[]values)
Ex: 
values = [2, 4, 6, 2, 8, 10, 4, 12, 14, 6]
result = [2, 4, 6, 8, 10, 12, 14]

 */

import java.util.ArrayList;

 class ProblemOne{

    
    public static void main(String[] args){

        ArrayUtils array = new ArrayUtils();

        // input of array
        int[] arr = array.inputArray();

        // remove duplicates
        int result[] = removeDuplicatesUsingList(arr);

        // print array
        array.printArray(result);

    }

    /*
     * MARK :- Remove duplicates from given array
     * INPUT :- int[]
     * OUTPUT :- int[] (new array without duplicates)
     * DESCRIPTION :- Remove duplicates from given array using Arraylist.
     */
    public static int[] removeDuplicatesUsingList(int[] values){
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<values.length; i++){
            if(!list.contains(values[i])){
                list.add(values[i]);
            }
        }

        int[] uniqueValue = new int[list.size()];
        for(int i=0; i<uniqueValue.length; i++){
            uniqueValue[i] = list.get(i);
        }

        return uniqueValue;
    }
 }