package day5;

/*
 * Q2. Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 */

 class ProblemTwo{
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,4,5};
        int[] nums2 = new int[]{10,11,12};

        System.out.println(sortedArrMedian(nums1, nums2));
    }

    /*
     * MARK :- Return median of two sorted array
     * INPUT :- int[], int[] (sorted non empty array)
     * OUTPUT :- int (median of array)
     * DESCRIPTION :- This method return median of two sorted array in constant space and time
     *                  median of odd length: (n/2)th element
     *                  median of even length: ( (n/2)th + (n/2 + 1)th )/2 element
     */
    public static int sortedArrMedian(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
    
        // odd
        if((m+n)%2 == 1){
            int medianIndex = (m+n)/2;
            if(medianIndex < nums1.length){
                return nums1[medianIndex];
            }
            else{
                medianIndex = medianIndex - nums1.length;
                return nums2[medianIndex];
            }

        }
        // even
        else{
            int medianIndexOne = (m+n)/2 - 1;
            int medianIndexTwo = medianIndexOne + 1;

            int median = -1;

            // when both indices lies int nums 1
            if(medianIndexTwo < nums1.length){
                median = (nums1[medianIndexOne] + nums1[medianIndexTwo])/2;
            }
            // when first index lies in num1 and second in nums 2
            else if(medianIndexOne < nums1.length && medianIndexTwo >= nums1.length){
                median = (nums1[medianIndexOne] + nums2[medianIndexTwo - nums2.length])/2;
            }
            // when length of nums2 is smaller then the second index and both indices lies in nums2
            else if(medianIndexTwo>nums2.length){
                median = (nums2[medianIndexOne - nums2.length] + nums2[medianIndexTwo - nums2.length])/2;
            }
            // when both indices lies in nums2 array
            else{
                median = (nums2[nums2.length - medianIndexOne] + nums2[nums2.length - medianIndexTwo])/2;
            }
            return median;
        }
    }
 }