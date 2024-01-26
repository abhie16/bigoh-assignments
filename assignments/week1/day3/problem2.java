/*

 ii) Write a method Boolean isKingSafe(int[][]chessBoard)
Returns true if king in the given chess board is safe from the given enemies otherwise false;
NOTE: Enemies are- Horse, Camel, Queen, Elephant only
Do not consider the colour case of the chess board for traversal of camel and all.

 */


class ProblemTwo{

    /*
     * MARK :- Check if given indices are in Bound of chess board
     * INPUT :- int, int
     * OUTPUT :- boolean
     */
    public static boolean inBound(int row, int col){
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    /*
     * MARK :- Mark position of horse
     * INPUT :- char[][], int , int
     * OUTPUT :- void
     * DESCRIPTION :- Mark all the moves of horse in chess board.
     */
    public static void checkHorse(char[][] board, int row, int col){

        // storing all possible moves direction of horse in form of x and y coordinates
        int[] x = {2,2,-2,-2,1,-1,1,-1};
        int[] y = {1,-1,1,-1,2,2,-2,-2};
        
        // check all move of horse on chess board
        for(int i=0; i<8; i++){
            if(inBound(row - x[i], col - y[i]) && board[row - x[i]][col - y[i]] == 'K') board[row - x[i]][col - y[i]] = 'x';
        }
    }

    /*
     * MARK :- Mark position of camel
     * INPUT :- char[][], int , int
     * OUTPUT :- void
     * DESCRIPTION :- Mark all the moves of camel in chess board.
     */
    public static void checkCamel(char[][] board, int row, int col){

        // max diagonal lenth is 8 so 1 t0 8;
        for(int i=1; i<8; i++){

            // check diagonally lower right
            if(inBound(row + i, col + i) && board[row + i][col + i] == 'K') board[row + i][col + i] = 'x';
            
            // check diagonally lower left
            if(inBound(row + i, col - i) && board[row + i][col - i] == 'K') board[row + i][col - i] = 'x';

            // check diagonally upper right
            if(inBound(row - i, col + i) && board[row - i][col + i] == 'K') board[row - i][col + i] = 'x';

            // check diagonally upper left
            if(inBound(row - i, col - i) && board[row - i][col - i] == 'K') board[row - i][col - i] = 'x';

        }

    }

    /*
     * MARK :- Mark position of Elephant
     * INPUT :- char[][], int , int
     * OUTPUT :- void
     * DESCRIPTION :- Mark all the moves of elephant in chess board.
     */
    public static void checkElephant(char[][] board, int row, int col){

        for(int i=0; i<8; i++){
            // check for king in the col
            if(board[row][i] == 'K') board[row][i] = 'x';


            // check for king in the row
            if(board[i][col] == 'K') board[i][col] = 'x';

        }
    }

    /*
     * MARK :- Check if King is safe or not
     * INPUT :- char[][]
     * OUTPUT :- boolean
     * DESCRIPTION :- Check if king is safe or not from Queen, Horse, Camel, Elephant
     */
    public static boolean isKingSafe(char[][] chessBoard){
        
        int kingPosition[] = new int[2];

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(chessBoard[i][j] != '.'){
                    if(chessBoard[i][j] == 'K'){
                        kingPosition[0] = i;
                        kingPosition[1] = j;
                    }
                    // check for king form queen using camel and elephant moves as it had same moves by combining both
                    if(chessBoard[i][j] == 'Q'){
                        checkCamel(chessBoard, i, j);
                        checkElephant(chessBoard, i, j);
                    }

                    // check for king as it is safe from horse
                    if(chessBoard[i][j] == 'H') checkHorse(chessBoard,i,j);

                    // check for king as it is safe from camel
                    if(chessBoard[i][j] == 'C') checkCamel(chessBoard,i,j);

                    // check for king as it is safe from elephant
                    if(chessBoard[i][j] == 'E') checkElephant(chessBoard,i,j);
                }
            }
        }
        return chessBoard[kingPosition[0]][kingPosition[1]] == 'K';
    }

    // main method
    public static void main(String[] args) {
        char[][] chessBoard = {
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','K','.','.','.','.'},
            {'.','.','E','.','E','.','.','.'},
            {'.','Q','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'}
    };

        System.out.println(isKingSafe(chessBoard));
        
    }
 }