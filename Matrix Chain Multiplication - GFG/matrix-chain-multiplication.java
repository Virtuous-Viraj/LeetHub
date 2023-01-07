//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int i = 1;
        int j = N-1;
        int dp[][] = new int[N][N];
        return helper(arr,i,j,dp);
    }
    
    private static int helper(int arr[], int i, int j, int[][] dp)
    {
        if(i==j) return 0 ; // matrix should not be multiplied with itself
        if(dp[i][j]!=0) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j-1; k++)
        {
            int steps = arr[i-1] * arr[k] * arr[j] + helper(arr,i,k, dp) + helper(arr,k+1,j,dp);
            min = Math.min(steps, min);
        }
        return dp[i][j] = min;
    }
}