package com.java.array;

/*

Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it.
Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order.
The designed algorithm should have linear time complexity.

Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
Output : Found at (2, 1)

Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 100
Output : Element not found

TC : O(n)

 */
public class SearchSortedMatrix {

    /*
    Let x = element we're trying to search for in the matrix,
    e = current element we're processing in the array.
    1) Start with top right element.
    2) Loop: compare this element e with x
    ...i) if e = x, then return position of e, since we found x in the given matrix.
    ...ii) if e > x then move left to check elements smaller than e (if out of bound of matrix, then break and return false)
    ...iii) if e < x then move below to check elements greater than e (if out of bound of matrix, then break and return false)
3) repeat the i), ii) and iii) until you find the element or return false
     */

    static void searchElement(int[][] array, int element){
        int m = array.length;
        int n = array[0].length;

        int i = 0, j = n -1;

        while(i < n && j >= 0){
            if(array[i][j] == element){
                System.out.println("Found the element @ "+i+" , "+j);
                return;
            }else if(array[i][j] > element){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("Element not found");
        return;
    }

    public static void main(String[] args) {
        int[][] array = {{10,20,30},
                         {40,50,60},
                         {70,80,90}};
        searchElement(array,60);
    }
}
