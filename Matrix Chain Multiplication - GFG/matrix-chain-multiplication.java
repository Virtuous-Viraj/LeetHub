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
        return helper(arr,dp,N);
    }
    
    private static int helper(int arr[], int[][] dp, int n)
    {
        for(int i = 0; i<n; i++)
        {
            dp[i][i] = 0;         //base case
        }
        
        for(int i = n-1;i>=1;i--)
        {
            for(int j = i+1; j<=n-1; j++)
            {
                int min = Integer.MAX_VALUE;
                for(int k = i; k<=j-1; k++)
                {
                    int steps = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(steps, min);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n-1];
    }
}