//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code 
        int dp[][] = new int[n][n+1];
        return helper(price, n, n-1, dp);
    }
    private static int helper(int[] price,int n,int id, int[][] dp)
    {
        //Base Cases
        if(id==0)
        {
            return n*price[0];
        }
        if(dp[id][n]!=0) return dp[id][n];
        //Calls
        int nonTake =  0 + helper(price,n, id-1, dp);
        int Take = Integer.MIN_VALUE;
        int rodlength = id + 1;
        if(rodlength<=n) Take = price[id] + helper(price,n-rodlength,id, dp);
        return dp[id][n] = Math.max(nonTake, Take);
    }
}