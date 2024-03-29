//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
//Optimize the Space
class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int dp[][] = new int[n+1][m+1];
        return helper(s1,s2,n,m,dp);
    }
    
    private static int helper(String s1, String s2, int n, int m, int[][] dp)
    {
        //write base cases
        int prev[] = new int[dp[0].length];
        // for(int i = 0; i<=n; i++) dp[i][0] = 0;
        // for(int j = 0; j<=m; j++) prev[j] = 0;
        int ans = 0;
        //Fill dp array
        for(int i = 1; i<=n; i++){
            int curr[] = new int[dp[0].length];
            for(int j = 1; j<=m; j++){
              if(s1.charAt(i-1)==s2.charAt(j-1))
              {
                  curr[j] = 1 + prev[j-1];
                  ans = Math.max(ans, curr[j]);
              }else{
                  curr[j] = 0;
              }   
            }
            prev = curr; 
        }

        // find length of longest substring and return
        return ans;
        
    }
}