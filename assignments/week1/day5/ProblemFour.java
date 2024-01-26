/*
 Question 4:
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
    Example 2:
    Input: height = [1,1]
    Output: 1
    Constraints:
        n == height.length
        2 <= n <= 105
        0 <= height[i] <= 104
 */

 package day5;

 public class ProblemFour {
    public static void main(String[] args) {
        int[] height = {7,2,3,4,5,6};

        System.out.println(mostWaterInContainer(height));
    }

    /*
     * MARK :- Find max water store between hieghts given
     * INPUT :- int[] ( array of heights of all the lines)
     * OUTPUT :- int (most amout of water can be stored between lines)
     * DESCRIPTION :- This method is findout max amout of water can be stored between line. It check water amount for all heights given.
     */
    public static int mostWaterInContainer(int[] height){
        int amountOfWater = 0;

        for(int i=0; i<height.length-1; i++){
            for(int j=i+1; j<height.length; j++){

                // check curr amount of water is max or not from till amout of water
                if(amountOfWater < Math.min(height[i],height[j]) * (j-i))
                    amountOfWater = Math.min(height[i],height[j]) * (j-i); // min of two heights multiply with gap between them -> (i-j)
            }
        }

        // int max = -1;
        // int maxValueIndex = 0;

        // for(int i=0; i<height.length; i++){
        //     if(max < height[i]){
        //         max = height[i];
        //         maxValueIndex = i;
        //     }
        // }

        // for(int j=maxValueIndex; j<height.length; j++){
        //     if((height[j]) * (j - maxValueIndex) > amountOfWater){
        //         amountOfWater = (height[j]) * (j - maxValueIndex);
        //     }
        // }

        return amountOfWater;
    }
 }