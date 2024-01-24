/*
    1. Write a method void printArray(int[][]arr)
    Prints array elements clockwise and anti-clockwise alternatively.
    Input : 
    1 2 3
    4 5 6
    7 8 9
    Output :
    1 2 3 6 9 8 7 4 5
    3 2 1 4 7 8 9 6 5
 */

 class ProblemOne{

    // MARK :- Print spiral matrix in clockwise
    // INPUT :- Integer 2d Array
    // OUTPUT :- void method (print matrix in clockwise)
    // DESCRIPTION :- This method print matrix in clockwise.
    public static void printClockWise(int[][] matrix){
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        int rowStart = 0;
        int rowEnd = matrix.length-1;

        while(true){
            // print col from left to right
            for(int col = colStart; col <= colEnd; col++){
                System.out.print(matrix[rowStart][col]);
            }
            rowStart++;
            if(rowStart > rowEnd) break;

            // print row top to bottom
            for(int row = rowStart; row <= rowEnd; row++ ){
                System.out.print(matrix[row][colEnd]);
            }
            colEnd--;
            if(colStart > colEnd) break;

            // print col form right to left
            for(int col = colEnd; col >= colStart; col-- ){
                System.out.print(matrix[rowEnd][col]);
            }
            rowEnd--;
            if(rowStart > rowEnd) break;

            // print row form bottom to up
            for(int row = rowEnd; row>=rowStart; row--){
                System.out.print(matrix[row][colStart]);
            }
            colStart++;
            if(colStart > colEnd) break;

        }
        
    }

    // MARK :- Print spiral matrix in clockwise
    // INPUT :- Integer 2d Array
    // OUTPUT :- void method (print matrix in Anticlockwise)
    // DESCRIPTION :- This method print matrix in Anticlockwise.
    public static void printAntiClockWise(int[][] matrix){

        // swap columns of the given matrix , so that printing clockwise gives same result as anticlockwise
        swapColumnInMatrix(matrix);

        // print clockwise
        printClockWise(matrix);
    }

    // MARK:- Swap Column into Matrix
    // INPUT :- Integer 2d Array
    // OUTPUT :- void method (swap columns)
    // DESCRIPTION :- Swaping the columns values into the matrix.
    public static void swapColumnInMatrix(int[][] matrix){
        int colStart = 0;
        int colEnd = matrix[0].length-1;

        while(colStart <= colEnd){
            for(int row = 0; row < matrix.length; row++){
                int temp = matrix[row][colStart];
                matrix[row][colStart] = matrix[row][colEnd];
                matrix[row][colEnd] = temp;
            }
            colEnd--;
            colStart++;
        }
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3,5},
            {1, 2, 3,6},
            {4, 5, 6,7},
            {7, 8, 9,9}
        };

        printClockWise(matrix);
        System.out.println(); // new line
        printAntiClockWise(matrix);
    }
 }