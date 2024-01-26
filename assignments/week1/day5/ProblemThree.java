/*
    Q3. You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.



    Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 Output: 3 3 4 5 5 5 6
    Explanation: 
        Maximum of 1, 2, 3 is 3
        Maximum of 2, 3, 1 is 3
        Maximum of 3, 1, 4 is 4
        Maximum of 1, 4, 5 is 5
        Maximum of 4, 5, 2 is 5 
        Maximum of 5, 2, 3 is 5
        Maximum of 2, 3, 6 is 6

    Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4 Output: 10 10 10 15 15 90 90 
    Explanation:    Maximum of first 4 elements is 10, similarly for next 4 elements (i.e from index 1 to 4) is 10, So the sequence generated is 10 10 10 15 15 90 90

    Return the max sliding window.
 */

 package day5;

import java.util.ArrayList;

public class ProblemThree {
    public static void main(String[] args) {
        int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}; 
        int windowSize = 10;

        // list to store all max value of generated windows
        ArrayList<Integer> maxSlidingWindowList = new ArrayList<>();

        // method to store max value of generated windows in a list
        maxSlidingWindow(arr, windowSize, maxSlidingWindowList);

        // showing the result
        for(int value : maxSlidingWindowList){
            System.out.print(value+" ");
        }
    }

    /*
     * MARK :- Find max sliding window in given array
     * INPUT :- int[], int, ArrayList<Integer>(array, windowsize, result)
     * OUTPUT :- void (store value in given list)
     * DESCRIPTION :- This method is used to store max value from the sliding window generated in the given array
     */
    public static void maxSlidingWindow(int[] arr, int windowSize, ArrayList<Integer> list){

        // sliding the window of window size over a array
        for(int i=0; i<arr.length-windowSize+1; i++){
            int max = -1;
            // iterating over a window
            for(int j=0; j<windowSize; j++){
                if(max<arr[i+j]) max = arr[i+j]; // checking max value in current window
            }
            list.add(max); // adding max value
        }

    }
 }