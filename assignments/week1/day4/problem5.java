/*
    5. You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    You have to rotate the image in place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

    Example 1:
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [[7,4,1],[8,5,2],[9,6,3]]
    Example 2:
    Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000
 */

 class ProblemFive{
    public static void main(String[] args) {

        int[][] matrix = {
            {1,2,3},{4,5,6},{7,8,9}
        };

        rotateMatrix90degClockwise(matrix);

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // MARK:- Rotate matrix 90 deg
    // INPUT :- Integer 2d Array
    // OUTPUT :- void method (swap columns)
    // DESCRIPTION :- Rotate given matrix 90 deg by swapping vertically and diagonally
    public static void rotateMatrix90degClockwise(int[][] matrix){
        
        // swap element up and down
        for(int rowNum=0; rowNum<matrix.length; rowNum++){
                int rowStart = 0;
                int rowEnd = matrix.length-1;
    
                // iterate over a row and swap element from start and end
                while(rowStart < rowEnd){
                    int temp = matrix[rowStart][rowNum];
                    matrix[rowStart][rowNum] = matrix[rowEnd][rowNum];
                    matrix[rowEnd][rowNum] = temp;
    
                    rowEnd--;
                    rowStart++;
                }
        }

        // swap element diagonally
        for(int row=0; row < matrix.length; row++){
            // col start from row number because 
            for(int col=row; col<matrix.length; col++){

                // swap element diagonally by interchanging there row number with col number9vice versa) -> A[0][1] have A[1][0] element as diagonally
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
 }