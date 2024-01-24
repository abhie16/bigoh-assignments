/*

 ii) Write a method Boolean isKingSafe(int[][]chessBoard)
Returns true if king in the given chess board is safe from the given enemies otherwise false;
NOTE: Enemies are- Horse, Camel, Queen, Elephant only
Do not consider the colour case of the chess board for traversal of camel and all.

 */


class problem2{

    // check if the given indices are in chess board bound
    public static boolean inBound(int row, int col){
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    // method to check if king is safe form horse
    public static boolean checkHorse(char[][] board, int row, int col, boolean[] isBlocked){

        // storing all possible moves direction of horse in form of x and y coordinates
        int[] x = {2,2,-2,-2,1,-1,1,-1};
        int[] y = {1,-1,1,-1,2,2,-2,-2};
        
        // check all move of horse on chess board
        for(int i=0; i<8; i++){
            if(inBound(row - x[i], col - y[i]) && board[row - x[i]][col - y[i]] == 'K') return true;
        }
        return false;
    }

    // method to check if king is safe form camel
    public static boolean checkCamel(char[][] board, int row, int col, boolean[] isBlocked){

        // max diagonal lenth is 8 so 1 t0 8;
        for(int i=1; i<8; i++){

            // check diagonally lower right
            if(inBound(row + i, col + i) && board[row + i][col + i] == 'K') return true;
            else if(inBound(row + i, col + i) && board[row + i][col + i] != 'K' && board[row + i][col + i] != '.')  isBlocked[0] = true;
            
            // check diagonally lower left
            if(inBound(row + i, col - i) && board[row + i][col - i] == 'K') return true;
            else if(inBound(row + i, col - i) && board[row + i][col - i] != 'K' && board[row + i][col - i] != '.') isBlocked[0] = true;

            // check diagonally upper right
            if(inBound(row - i, col + i) && board[row - i][col + i] == 'K') return true;
            else if(inBound(row - i, col + i) && board[row - i][col + i] != 'K' && board[row - i][col + i] != '.') isBlocked[0] = true;

            // check diagonally upper left
            if(inBound(row - i, col - i) && board[row - i][col - i] == 'K') return true;
            else if(inBound(row - i, col - i) && board[row - i][col - i] != 'K' && board[row - i][col - i] != '.') isBlocked[0] = true;

        }

        return false;
    }

    // method to check if king is safe form elephant
    public static boolean checkElephant(char[][] board, int row, int col, boolean[] isBlocked){

        for(int i=0; i<8; i++){
            // check for king in the col
            if(board[row][i] == 'K') return true;
            else if(board[row][i] != 'K' && board[row][i] != '.') isBlocked[0] = true;


            // check for king in the row
            if(board[i][col] == 'K') return true;
            else if(board[i][col] != 'K' && board[i][col] != '.') isBlocked[0] = true;

        }

        return false;
    }

    // main method to check king safety form queen, horse, camel, elephant
    public static boolean isKingSafe(char[][] chessBoard){
        boolean[] isBlocked = {false};

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(chessBoard[i][j] != '.'){
                    
                    // check for king form queen using camel and elephant moves as it had same moves by combining both
                    if(chessBoard[i][j] == 'Q' && (checkCamel(chessBoard, i, j, isBlocked) || checkElephant(chessBoard, i, j, isBlocked))) return isBlocked[0]?false:true;

                    // check for king as it is safe from horse
                    if(chessBoard[i][j] == 'H' && checkHorse(chessBoard,i,j, isBlocked)) return isBlocked[0]?false:true;

                    // check for king as it is safe from camel
                    if(chessBoard[i][j] == 'C' && checkCamel(chessBoard,i,j, isBlocked)) return isBlocked[0]?false:true;

                    // check for king as it is safe from elephant
                    if(chessBoard[i][j] == 'E' && checkElephant(chessBoard,i,j, isBlocked)) return isBlocked[0]?false:true;
                }
            }
        }
        return isBlocked[0]?false:true;
    }

   
    public static void main(String[] args) {
        char[][] chessBoard = {
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','K','.','Q','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'}
    };

        System.out.println(isKingSafe(chessBoard));
        
    }
 }