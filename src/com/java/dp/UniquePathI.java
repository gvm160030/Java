package com.java.dp;
/*
The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints
that from each cell you can either move only to right or down

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

TC: O(mn) | SC: O(n)
 */
public class UniquePathI {
    // Returns count of possible paths to reach
    // cell at row number m and column number n from
    // the topmost leftmost cell (cell at 1, 1)
    static int numberOfPaths(int m, int n)
    {
        // Create a 1D array to store results of subproblems
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        System.out.println(numberOfPaths(4, 4));
    }
}
