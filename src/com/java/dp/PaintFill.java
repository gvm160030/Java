package com.java.dp;

/*
In MS-Paint, when we take the brush to a pixel and click, the color of the region of that pixel is replaced with a new selected color. Following is the problem statement to do this task.
Given a 2D screen, location of a pixel in the screen and a color, replace color of the given pixel and all adjacent same colored pixels with the given color.

Example:

Input:
       screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 2, 2, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 2, 2, 0},
                      {1, 1, 1, 1, 1, 2, 1, 1},
                      {1, 1, 1, 1, 1, 2, 2, 1},
                      };
    x = 4, y = 4, newColor = 3
The values in the given 2D screen indicate colors of the pixels.
x and y are coordinates of the brush, newColor is the color that
should replace the previous color on screen[x][y] and all surrounding
pixels with same color.

Output:
Screen should be changed to following.
       screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 3, 3, 3, 3, 0, 1, 0},
                      {1, 1, 1, 3, 3, 0, 1, 0},
                      {1, 1, 1, 3, 3, 3, 3, 0},
                      {1, 1, 1, 1, 1, 3, 1, 1},
                      {1, 1, 1, 1, 1, 3, 3, 1},
                      };
 */
public class PaintFill {

    static void fillPaint(int[][] array, int r, int c, int nColor){

        if(array[r][c] == nColor) return;
        fillPaint(array,r, c, array[r][c], nColor);

    }

    private static boolean fillPaint(int[][] array, int r, int c, int oColor, int nColor) {
        if(r < 0 || r>= array.length || c < 0 || c >= array[0].length){
            return false;
        }

        if(array[r][c] == oColor){
            array[r][c] = nColor;
            fillPaint(array,r - 1, c, oColor,nColor);
            fillPaint(array, r + 1, c, oColor, nColor);
            fillPaint(array,r, c - 1, oColor, nColor);
            fillPaint(array, r, c + 1, oColor,nColor);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 1},
                         {1, 1, 1},
                         {3, 1, 4}};
        fillPaint(array,1, 1, 5);
        for(int i = 0; i <array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
