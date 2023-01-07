//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int mod = 1003;
    static int countWays(int N, String S){
        // code here
        int i = 0;
        int j = S.length()-1;
        int isTrue = 1;
        int dp[][][] = new int[N][N][2];
        // return helper(i,j,S,isTrue,dp,int N);
        return helper(S, dp, N);
    }
    
    
    private static int helper( String s, int[][][] dp, int N)
    {
        // if(i>j) return 0;
        
        // if(i==j)
        // {
        //     if(isTrue==1) return s.charAt(i)=='T'? 1: 0;
        //     else return s.charAt(i)=='F'? 1:0;
                
        // }
        for (int i = 0; i < N; i++)
        {
            dp[i][i][1] = s.charAt(i) == 'T'?1:0;
            dp[i][i][0] = s.charAt(i) == 'F'?1:0;
        }
        
        for(int i = N-1; i>=0; i--)
        {
            for(int j = i+1; j<N; j++)
            {
                if(i>j) continue;
                for(int isTrue = 0; isTrue<2; isTrue++)
                {
                        int ways = 0;
                        
                        for(int ind=i+1; ind<j; ind+=2)
                        {
                            int lT = dp[i][ind-1][1];
                            int lF = dp[i][ind-1][0];
                            int rT = dp[ind+1][j][1];
                            int rF = dp[ind+1][j][0];
                            
                            if(s.charAt(ind)=='&')
                            {
                                if(isTrue==1) ways = (ways + (rT * lT)%mod)%mod;
                                else ways = (ways + (lT*rF)%mod + (lF*rT)%mod + (lF*rF)%mod) % mod;
                            }
                            else if(s.charAt(ind)=='|')
                            {
                                if(isTrue==1) ways = (ways + (lT*rT)%mod + (lT*rF)%mod + (rT*lF)%mod)%mod;
                                else ways = (ways + (lF * rF)%mod)%mod;
                            }
                            else if(s.charAt(ind)=='^')
                            {
                                if(isTrue==1) ways = (ways + (lT*rF)%mod + (rT*lF)%mod)%mod;
                                else ways = (ways + (lT*rT)%mod + (lF*rF)%mod)%mod;
                            }
                        }
                        dp[i][j][isTrue] = ways;
                }
            }
        }
        // if(dp[i][j][isTrue] !=0) return dp[i][j][isTrue];

        return dp[0][N-1][1];
    }
}