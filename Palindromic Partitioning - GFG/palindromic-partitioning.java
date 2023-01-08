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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String s)
    {
        // code here
        int n = s.length();
        int dp[] = new int[n+1];
        dp[n] = 0;
        for(int i = n-1; i>=0; i--)
        {
        String temp = "";
        int min = Integer.MAX_VALUE;
        for(int j = i; j<n; j++)
        {
                temp+=s.charAt(j);
                if(isPalindrome(temp))
                {
                    int cost = 1 + dp[j+1];
                    min = Math.min(cost,min);
                }

        }
                dp[i] = min;
        }
        return dp[0]-1;
    }
    private static boolean isPalindrome(String s)
    {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}