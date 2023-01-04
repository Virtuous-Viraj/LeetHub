//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String word1, String word2) {
        // Code here
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        return helper(word1,word2,m,n, dp);
    }
    
    private static int helper(String s1, String s2, int m, int n, int[][]dp)
    {
        for(int i = 0; i<=m; i++) dp[i][0] = i; 
        for(int j = 0; j<=n; j++) dp[0][j] = j;

        for(int i = 1; i<=m; i++)
        {
            for(int j = 1; j<=n; j++)
            {
            if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] =   0 + dp[i-1][j-1];
            else
            dp[i][j] = Math.min(
               1+ dp[i-1][j-1],  //replace
               Math.min(
                   1+ dp[i-1][j],  //delete 
                   1+dp[i][j-1]));  //insert
            }
        }
        return dp[m][n];
    }
}