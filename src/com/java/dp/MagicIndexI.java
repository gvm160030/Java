package com.java.dp;

/*
Objective: Given a sorted array of distinct integers, Find the Magic index or Fixed point in the array.

Magic Index or Fixed Point: Magic index or a Fixed point in an array is an index i in the array such that A[i] = i.

Better solution would Modify the Binary Search – Time Complexity O(logN).

Check mid = (start+end)/2, with A[mid], check if A[mid] = mid. if yes then return mid.
If mid>A[mid] means fixed point might be on the right half of the array, make a recursive call to search(A, mid + 1, end).
If mid<A[mid] means fixed point might be on the left half of the array, make a recursive call to search(A, start, mid – 1).
 */
public class MagicIndexI {
    // perform modified binary search
    public int search(int[] A, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (mid == A[mid]) // check for magic index.
                return mid;
            if (mid > A[mid]) { // If mid>A[mid] means fixed point might be on
                // the right half of the array
                return search(A, mid + 1, end);
            } else {// If mid<A[mid] means fixed point might be on
                // the left half of the array
                return search(A, start, mid - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = { -1, 0, 1, 2, 4, 10 };
        MagicIndexI m = new MagicIndexI();
        System.out.println("Magic index " + m.search(A, 0, A.length - 1));
    }

}
