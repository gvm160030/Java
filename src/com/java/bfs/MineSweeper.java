package com.java.bfs;

import java.util.Arrays;

public class MineSweeper {
    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}, {-1,-1}, {-1, 1},{1,-1}, {1,1}};
    public static char[][] updateBoard(char[][] board, int[] click) {

        if(board[click[0]][click[1]] == 'M')
        {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        bfs(board, click[0], click[1]);
        return board;
    }

    static void bfs(char[][] board, int i, int j)
    {
        if((board[i][j] <= '8' && board[i][j] >= '1') || board[i][j] == 'B') {
            return;
        }

        board[i][j] = 'B';

        int mines = 0;
        for(int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x<0||y<0||x>=board.length||y>=board[0].length)
                continue;

            if(board[x][y] == 'M')
                mines++;
        }

        if(mines>0)
        {
            System.out.println("i : "+i+" and j : "+j+" | "+mines);
            board[i][j] = (char) (mines + 48);
            return;
        }

        for(int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x<0||y<0||x>=board.length||y>=board[0].length || board[x][y] != 'E')
                continue;

            bfs(board, x, y);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = {3,0};
        System.out.println(Arrays.deepToString(updateBoard(board,click)));
    }

}
