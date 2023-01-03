//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
        int id1 = str1.length();
        int id2 = str2.length();
        int dp[][] = new int[id1+1][id2+1];
        int lcs = helper(id1,id2,str1,str2,dp);
        int deletions = id1 - lcs;
        int insertions = id2 - lcs;
        return insertions + deletions;
	} 

    private static int helper(int id1, int id2, String s1, String s2, int[][] dp)
    {
        for(int i = 0; i<id1+1; i++) dp[i][0] = 0;
        for(int j = 0; j<id2+1; j++) dp[0][j] = 0;

        for(int i = 1; i<=id1; i++)
        {
            for(int j = 1;j<=id2; j++)
            {
            if(s1.charAt(i-1)==s2.charAt(j-1)) 
                    dp[i][j] = 1 + dp[i-1][j-1];

            else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[id1][id2];
    }
}