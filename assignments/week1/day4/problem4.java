/*
    4. Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are surrounded by water.
    Input: grid = [
    ["1","1","1","1","0"],
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
    ]
    Output: 1
    Input: grid = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
    ]
    Output: 3
 */

 class ProblemFour{
    public static void main(String[] args) {
        String grid[][] = {
            {"1","1","0","1","0"},
            {"1","1","0","1","0"},
            {"1","1","0","0","0"},
            {"0","0","0","0","0"}
        };

        System.out.println(numberOfIsland(grid));
    }

    /*
     * MARK :- Find number of islands
     * INPUT :- Integer 2d Array
     * OUTPUT :- int value
     * DESCRIPTION :- Find all islands in the given matrix
     */
    public static int numberOfIsland(String[][] grid){
        int count = 0;

        // iterating over 2d grid
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){

                // if land occurs
                if(grid[row][col].equals("1")){

                    // check all connected land by recursion
                    visitConnectedLand(grid,row,col);

                    // count number of times land occurs that is not connected to each other
                    count++;
                }
            }
        }
        return count;
    }

    /*
     * MARK :- Mark all value that is visited
     * INPUT :- Integer 2d Array, int , int
     * OUTPUT :- void method 
     * DESCRIPTION :- Mark visited land with 0 using recursion
     */
    public static void visitConnectedLand(String[][] grid, int row, int col){

        // condition to check if row and col are in bound and value is 1
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col].equals("1")){    

            grid[row][col] = "0"; // after visitng land ,mark it 0 so not visit it again.

            visitConnectedLand(grid, row+1, col); // check down by changin row only  
            visitConnectedLand(grid, row-1, col); // check up by changing row only
            visitConnectedLand(grid, row, col+1); // check right by changing col only
            visitConnectedLand(grid, row, col-1); // check left by changing col only 

        }
    }
 }