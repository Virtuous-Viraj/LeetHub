//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] arr , int n, int d) {
        // code here
        // int n = arr.length;
        if(n==1) return (Math.abs(arr[0])==Math.abs(d))? 1 : 0;
        int sum = 0;
	    for(int i = 0; i<n ; i++)
	    {
	        sum += arr[i];
	    }
	    if((sum-d)<0 || (sum-d)%2!=0) return 0;
	    int dp[][] = new int[n][sum+1];
	    int tot = (sum-d)/2;
	    return helper(arr, n , tot, dp);
    }
    
	private static int helper(int arr[], int n, int sum, int[][] dp)
	{
        if(arr[0]==0) dp[0][0] = 2;
        else dp[0][0] = 1;
        
        
	    if(arr[0]!=0 && arr[0]<= sum) dp[0][arr[0]]  = 1;
	    for(int i = 1 ; i<n; i++)
	    {
	        for(int tar = 0; tar<=sum; tar++)
	        {
	            int nonTake = dp[i-1][tar];
	            int Take = 0;
	            if(arr[i]<=tar) Take = dp[i-1][tar-arr[i]];
	            dp[i][tar] = (nonTake + Take);
	        }
	    }
	    return dp[n-1][sum];
	}
};