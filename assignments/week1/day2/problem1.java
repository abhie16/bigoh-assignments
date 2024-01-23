/*

i)Write a program to remove duplicate values from an array and returns an array of unique values. int[] removeDuplicates(int[]values)
Ex: 
values = [2, 4, 6, 2, 8, 10, 4, 12, 14, 6]
result = [2, 4, 6, 8, 10, 12, 14]

 */

import java.util.ArrayList;
import java.util.HashMap;

 class problem1{

    
    public static void main(String[] args){

        ArrayUtils array = new ArrayUtils();

        // input of array
        int[] arr = array.inputArray();

        // remove duplicates
        int result[] = removeDuplicatesUsingList(arr);

        // print array
        array.printArray(result);

    }


    // using arraylist
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

    // using hashmap
    public static int[] removeDuplicates(int[] values){
        HashMap<Integer, Integer> mapOfValues = new HashMap<>();

        for(int i=0; i<values.length; i++){
            if(!mapOfValues.containsKey(values[i])){
                mapOfValues.put(values[i], 1);
            }
        }

        int[] uniqueValue = new int[mapOfValues.size()];

        int index = 0;
        for(int value : mapOfValues.keySet()){
            uniqueValue[index++] = value;
        }


        return uniqueValue;
    }
 }