
import java.util.Arrays;
import java.util.Scanner;

/**
 * TicTacToe
 */
public class TicTacToe {

    private char[][] GAME_BOARD = new char[3][3];

    String[][] inputOption = {
        {"Top-Left", "Top-Center", "Top-Right"},
        {"Center-Left", "Center", "Center-Right"},
        {"Bottom-Left", "Bottom-Center", "Bottom-Right"}
    };

    public static void main(String[] args) {
        TicTacToe obj = new TicTacToe();
    }

    public TicTacToe(){
        generateBoard();
        playGame('O'); 
    }

    public void playGame(char ch){
        while(true){        
            showBoard();
            
            int input = userInput(ch);
            if(input == -1) return;
            if(isWin(input/3, input%3, ch)){
                if(ch == 'X') {
                    System.out.println("================= Player 2 Win =================");
                    showBoard();
                    System.out.println("================= Player 2 Win =================");
                };
                if(ch =='O') {
                    System.out.println("================= Player 1 Win =================");
                    showBoard();
                    System.out.println("================= Player 1 Win =================");
                }
                return;
            }
            if(isAllFill()){
                showBoard();
                System.out.println("================= DRAW =================");
                return;
            }

            
            if(ch == 'O') ch = 'X';
            else {
                computerPlay(ch);
                ch = 'O';
            }
        } 
    }
    
    public void generateBoard(){
        Arrays.fill(GAME_BOARD[0], '_');
        Arrays.fill(GAME_BOARD[1], '_');
        Arrays.fill(GAME_BOARD[2], '_');    
    }
    
    public void showBoard(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(GAME_BOARD[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void resetBoard(){
        new TicTacToe();
    }

    public boolean isAllFill(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(GAME_BOARD[i][j] == '_') return false;
            }
        }

        return true;
    }
    public int checkUserInput(int optionNumber){
        if(optionNumber > 0 && optionNumber<10){
            return 0;
        }
        else if(optionNumber == 10){
            return 1;
        }
        else{
            System.out.println("Enter correct option number");
            return 2;
        }
    }

    public int userInput(char ch){
        Scanner scn = new Scanner(System.in);

        System.out.println("Choose Number of option: ");

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!inputOption[i][j].equals("filled"))
                    System.out.print((3*i+j+1) +". "+inputOption[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("10. Exit");
        
        int optionNumber = scn.nextInt();
        int status = checkUserInput(optionNumber);

        if(status == 0){
            optionNumber--;
            int row = optionNumber/3;
            int col = optionNumber%3;
            int isFilled = fillBoard(row, col, ch);
            if(isFilled == 0)
                inputOption[row][col] = "filled";
            else{
                userInput(ch);
            }
        }
        else if( status == 1){
            return -1;
        }
        else if( status == 2){
            userInput(ch);
        }

        return optionNumber;
    }

    /*
     * MARK :- Fill the board with given character
     * INPUT :- int, int, char (row, col, character)
     * OUTPUT :- void method
     */
    public int fillBoard(int row, int col, char ch){
        if(GAME_BOARD[row][col] == '_'){
            GAME_BOARD[row][col] = ch;
            return 0;
        }
        else{
            return -1;
        }
    }

    /*
     * MARK :- Exit game
     */
    public void exitGame(){
        return;
    }

    /* Computer Play */

    public void computerPlay(char ch){
        int[] pos = getPosition(ch);
        inputOption[pos[0]][pos[1]] = "filled";
        fillBoard(pos[0], pos[1], ch);
        showBoard();
    }

    public int[] getPosition(char ch){
        int[] res = new int[2];

        int[][] numberOfMoves = ai(ch);
        int minMoves = 3;

        for(int i=0; i<3; i++)  {
            for(int j=0; j<3; j++){
                if(minMoves>numberOfMoves[i][j]){
                    res[0] = i;
                    res[1] = j;
                    minMoves = numberOfMoves[i][j];
                }
            }
        }

        return res;
    }

    public int[][] ai(char ch){
        int[][] numberOfMoves = new int[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(ch == '_'){
                    numberOfMoves[i][j] = checkMovesToWin(i,j,ch, new int[]{0});
                }
            }
        }

        return numberOfMoves;
    }

    public int checkMovesToWin(int row, int col, char ch, int[] res){
        
        if(isWin(row, col, ch)){
            return res[0];
        }
        else{
            int count = 0;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(GAME_BOARD[i][j] == '_'){
                        GAME_BOARD[i][j] = ch;
                        res[0]++;
                        count += checkMovesToWin(i, j, ch, res);
                        GAME_BOARD[i][j] = '_';
                        res[0]--;
                    }
                }
            }
            return count;
        }
    }

    /*
     * MARK :- Check if current player win the game or not
     */
    public boolean isWin(int row, int col, char ch){
        int countRow = 0;
        int countCol = 0;
        for(int i=0; i<3; i++){
            if(inBound(i, col) && GAME_BOARD[i][col] == ch) countRow++;
            if(inBound(row,i) && GAME_BOARD[row][i] == ch) countCol++;
        }
        if(countCol == 3 || countRow == 3) return true;
        else{
            int lowerRight = 0;
            int upperRight = 0;
            int lowerLeft = 0;
            int upperLeft = 0;
            // max diagonal lenth is 3 so 1 t0 3;
            for(int i=0; i<3; i++){

                // check diagonally lower right
                if(inBound(row + i, col + i) && GAME_BOARD[row + i][col + i] == ch) lowerRight++;
                
                // check diagonally lower left
                else if(inBound(row + i, col - i) && GAME_BOARD[row + i][col - i] == ch) lowerLeft++;

                // check diagonally upper right
                else if(inBound(row - i, col + i) && GAME_BOARD[row - i][col + i] == ch) upperRight++;

                // check diagonally upper left
                else if(inBound(row - i, col - i) && GAME_BOARD[row - i][col - i] == ch) upperLeft++;

            }
            
            if(upperRight + lowerLeft == 3 || upperLeft + lowerRight == 3) return true;

            return false;
        }
    }

    /*
     * MARK :- Check if row and col are in Bound
     */
    public boolean inBound(int row, int col){
        return row >=0 && row < 3 && col >= 0 && col < 3;
    }
}