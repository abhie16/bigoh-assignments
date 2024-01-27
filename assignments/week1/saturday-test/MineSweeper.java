/*
 * MARK :- This program is a simple version of the game minesweeper.
 */

import java.util.Scanner;

public class MineSweeper {
    /*
     * MARK :- Main Method
     */
    public static void main(String[] args){
        MineSweeper obj = new MineSweeper();
    }

    /*
     * MARK :- Constructor of MineSweeper class
     */
    public MineSweeper(){
        Scanner scn = new Scanner(System.in);
        
        // play until user want to exit
        while(true){
            System.out.println("Enter 1 to play  or 2 to exit: ");
            int userInput = scn.nextInt();
            if(userInput==1) createBoard();
            else break;
        }
    }

    /*
     * MARK :- Method to create board with mines and bombs
     * INPUT :- None
     * OUTPUT :- void
     * DESC :- This method is used to create board with randomly generate bombs and then prompt user to enter mines in their coordinates and then check if
     *          it is safe to place mine or not, it not then game over.
     */
    public void createBoard(){

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the size of the board: ");
        int size = scn.nextInt();
        char[][] board = new char[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                board[i][j] = '0';
            }
        }

        placedBombs(board);

        int result = 0;
        boolean isFirstMoveBomb = false;
        System.out.println("Enter the number of mines: ");
        int mines = scn.nextInt();

        // mines should be less then n*n - n;
        if(mines > size*size-size){
                System.out.println("Number of mines cannot be greater then "+((size*size) - size));
                return;
        }
        else{
            for(int i=0; i<mines; i++){
                System.out.println("Enter the row and column of the mine: ");
                int row = scn.nextInt();
                int col = scn.nextInt();
                if(board[row][col] == '*'){
                    if(i ==0 ){
                        isFirstMoveBomb = true;
                        continue;
                    }
                    System.out.println("======== You stepped on a mine. Game Over ========");
                    break;
                }
                else if(board[row][col] == '0'){
                    result++;
                    board[row][col] = '1';
                }
                else{
                    i--;
                }
            }
        }
            

        if((result == mines-1 && isFirstMoveBomb) || result == mines){
            System.out.println("======== You successfully placed all mine. You win ========");
        }

        // print board after placing mines
        printBoard(board);

    
    }



    /*
     * MARK :- Method to print board
     * INPUT :- char[][]
     * OUTPUT :- void
     * DESC :- This method is used to print board elements
     */
    public void printBoard(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    /*
     * MARK :- Method to place bombs in form of "*" in given board
     * INPUT :- char[][]
     * OUTPUT :- void
     * DESC :- This method is used to place n bombs randomly in given board
     */
    public void placedBombs(char[][] board){
        for(int i=0; i<board.length; i++){
            int row = (int)(Math.random()*board.length); // generate random row ( 0 to board length - 1);
            int col = (int)(Math.random()*board.length); // generate random row ( 0 to board length - 1);
            if(board[row][col] == '0'){
                board[row][col] = '*';
            }
            else{
                i--;
            }
        }
    }
  
}
