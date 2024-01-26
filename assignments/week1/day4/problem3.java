/*
    3. Write an efficient algorithm that searches for a value in a m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    Output: true
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104
 */

 class ProblemThree{
    public static void main(String[] args) {
        int[][] matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target = 6;

        System.out.println(searchInMatrix(matrix,target));
    }

    /*
     * MARK :- Search value into Matrix
     * INPUT :- Integer 2d Array and target value
     * OUTPUT :- boolean
     * DESCRIPTION :- Search given target in 2d array using binary search
     */
    public static boolean searchInMatrix(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = row*col - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(matrix[mid/col][mid%col] == target) return true;
            else if(matrix[mid/col][mid%col] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
 }