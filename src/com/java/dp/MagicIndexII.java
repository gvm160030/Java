package com.java.dp;

/*
Finding magic index when the elements in the array are not distinct
 */
public class MagicIndexII {

    static int getMagicIndex(int[] array, int start, int end){

        if(end < start) return -1;
        int midIndex = (start + end) /2;
        int midValue = array[midIndex];

        if(midValue == midIndex){
            return midIndex;
        }


        // Search left
        int leftIndex = Math.min(midIndex - 1,midValue);
        int left = getMagicIndex(array, start, leftIndex);
        if(left >= 0){
            return left;
        }

        // Search right
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = getMagicIndex(array, rightIndex, end);

        return right;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = { -10, -5, 2, 2, 2, 3, 4, 7, 9 ,12, 13 };
        MagicIndexII m = new MagicIndexII();
        System.out.println("Magic index " + m.getMagicIndex(A, 0, A.length - 1));
    }
}
