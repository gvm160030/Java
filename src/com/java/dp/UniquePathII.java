package com.java.dp;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
 */
public class UniquePathII {

    /*
    Algorithm

If the first cell i.e. obstacleGrid[0,0] contains 1, this means there is an obstacle in the first cell.
Hence the robot won't be able to make any move and we would return the number of ways as 0.
Otherwise, if obstacleGrid[0,0] has a 0 originally we set it to 1 and move ahead.

Iterate the first row. If a cell originally contains a 1, this means the current cell has an obstacle
and shouldn't contribute to any path. Hence, set the value of that cell to 0.
Otherwise, set it to the value of previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i,j-1]

Iterate the first column. If a cell originally contains a 1,
this means the current cell has an obstacle and shouldn't contribute to any path.
Hence, set the value of that cell to 0. Otherwise, set it to the value of previous cell
i.e. obstacleGrid[i,j] = obstacleGrid[i-1,j]

Now, iterate through the array starting from cell obstacleGrid[1,1].
If a cell originally doesn't contain any obstacle then the number of ways of reaching that cell
would be the sum of number of ways of reaching the cell above it and number of ways of reaching
the cell to the left of it.

 obstacleGrid[i,j] = obstacleGrid[i-1,j] + obstacleGrid[i,j-1]
If a cell contains an obstacle set it to 0 and continue. This is done to make sure it doesn't contribute to any
other path.

     */
    static int uniquePathWithObstacles(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (grid[0][0] == 1) return 0;

        // Number of ways of reaching the starting cell = 1.
        grid[0][0] = 1;

        // Filling the values for the first column

        for(int i = 1; i < r; i++)
            grid[i][0] = (grid[i][0] == 0 && grid[i-1][0] == 1) ? 1 : 0;

            for(int j = 1; j < c; j++)
                grid[0][j] = (grid[0][j] == 0 && grid[0][j-1] == 1) ? 1 : 0;

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.

        for(int i = 1; i< r; i++){
            for(int j = 1; j<c; j++){
                if(grid[i][j] == 0){
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }else{
                    grid[i][j] = 0;
                }
            }
        }
        return grid[r-1][c-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},
                {0,1,0},
                {0,0,0}};
        System.out.println(uniquePathWithObstacles(grid));
    }
}
