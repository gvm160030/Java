package com.java.dp;

/*
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb
either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.

APPROACH :
We can easily find recursive nature in above problem.
The person can reach n’th stair from either (n-1)’th stair or from (n-2)’th stair.
Let the total number of ways to reach n’t stair be ‘ways(n)’. The value of ‘ways(n)’ can be written as following.

    ways(n) = ways(n-1) + ways(n-2)

* How to count number of ways if the person can climb up to m stairs for a given value m?
* For example if m is 4, the person can climb 1 stair or 2 stairs or 3 stairs or 4 stairs at a time.

We can write the recurrence as following.
   ways(n, m) = ways(n-1, m) + ways(n-2, m) + ... ways(n-m, m)

TC : O(mn)
 */

public class StaircaseProblem {
    static int countWaysUtil(int n, int m)
    {
        int res[] = new int[n];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<n; i++)
        {
            res[i] = 0;
            for (int j=1; j<=m && j<=i; j++)
                res[i] += res[i-j];
        }
        return res[n-1];
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s, int m)
    {
        return countWaysUtil(s+1, m);
    }

    // Driver method
    public static void main(String[] args)
    {
        int s = 5, m = 5;
        System.out.println("Nuber of ways = " + countWays(s, m));
    }
}
