/*

 i) Write a method Boolean isValidSudoku(int[][]Sudoku)
Returns true if the given Sudoku is correctly arranged otherwise false
Write a method Boolean isValidSudoku(int[][]Sudoku)Returns true if the given Sudoku is correctly arranged otherwise false
Determine if a 9 x 9 The Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Example :
Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false

 */


class problem1{
    public static void main(String[] args) {
        String[][] sudoku = {
         {"5","3",".",".","7",".",".",".","."}
        ,{"6",".",".",".","9","5",".",".","."}
        ,{".","9","8",".",".",".",".","4","."}
        ,{"8",".",".",".","6",".",".",".","3"}
        ,{"4",".",".","8",".","3",".",".","1"}
        ,{"7",".",".",".","2",".",".",".","6"}
        ,{".",".",".","1",".",".","2","8","."}
        ,{".",".",".","4",".","9",".",".","5"}
        ,{".",".","1",".","8",".",".","7","9"}};

        boolean result = isValidSudoku(sudoku);

        System.out.println(result);
    }

    // method to check if given sudoku is valid or not
    public static boolean isValidSudoku(String[][] sudoku){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(!sudoku[i][j].equals(".")){
                    String currNum = sudoku[i][j];
                    if(!isValid(sudoku,i,j, currNum)) return false;
                }
            }
        }
        return true;
    }

    // method to check if given value is in correct position in sudoku or not
    public static boolean isValid(String[][] sudoku, int row, int col, String value){
        
        for(int i=0; i<9; i++){

            // check digit in the col
            if(sudoku[row][i].equals(value) && col != i) return false;

            // check digit in the row
            if(sudoku[i][col].equals(value) && row != i) return false;

            // check digit in 3 x 3 gird
            // 3*(row/3) + i/3 -> formula to get the starting row num of 3 x 3 grid of given row index
            // 3*(row/3) + i%3 -> formula to get the starting col num of 3 x 3 grid of given col index
            if(sudoku[3*(row/3) + i/3][3*(col/3) + i%3].equals(value) && (3*(row/3) + i/3) != row && (3*(col/3) + i%3) != col) return false;

            /*
             * why 3*(row/3) + i/3 works?
             * 
             * -> sudoku have 3 grid of  3 x 3 , by diving row by 3 and then multiplying by 3 we get grid number for given row, same goes for col also
             *    and we are iterating over 3 x 3 so for iterating we are adding i/3 in row and i%3 in col as loop is from 0 to 9.
             */
        }
        return true;
    }
}