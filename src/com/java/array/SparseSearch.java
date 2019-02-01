package com.java.array;

/*

Given a sorted array of strings which is interspersed with empty strings,
write a method to find the location of a given string.

Examples:

Input : arr[] = {"for", "geeks", "", "", "", "", "ide",
                      "practice", "", "", "", "quiz"}
          x = "geeks"
Output : 1

Input : arr[] = {"for", "geeks", "", "", "", "", "ide",
                      "practice", "", "", "", "quiz"},
          x = "ds"
Output : -1

 */
public class SparseSearch {

    static int binarySearch(String strings[],int first, int last, String x){
        if (first > last) return -1;
        int mid = (last + first) / 2;

        // If mid is empty, find closest non-empty string
        if (strings[mid].isEmpty()){
            int left = mid - 1;
            int right = mid + 1;
            while (true){
                if (left < first && right > last){
                    return -1;
                }
                else if (right <= last && !strings[right].isEmpty()){
                    mid = right;
                    break;
                }
                else if (left >= first && !strings[left].isEmpty()){
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

        if (x.equals(strings[mid])){ // Found it!
            return mid;
        }
        else if (strings[mid].compareTo(x) < 0){ // Search right
            return binarySearch(strings, mid + 1, last, x);
        }
        else {
            return binarySearch(strings, first, mid - 1,x);
        }
    }

    public static void main(String[] args) {
        String arr[] = {"for", "geeks", "", "", "", "", "ide",
                "practice", "", "", "", "quiz"};
        String x = "quiz";
        int n = arr.length;
        int index = binarySearch(arr, 0, n-1, x);
        if (index != -1)
            System.out.println(x+ " found at index "+index);
        else
            System.out.println(x+" not found");
    }
}
