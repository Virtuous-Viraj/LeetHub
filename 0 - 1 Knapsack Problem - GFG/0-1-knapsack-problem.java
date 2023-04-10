//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][] = new int[W+1][n];
         return helper(W, wt,val,n-1, dp);
    } 
    
    static int helper(int W, int wt[], int val[], int id, int dp[][])
    {
        if(id==0)
        {
            if(wt[0]<=W)
            {
                return val[0];
            }
            else{
                return 0;
            }
        }
        if(dp[W][id]!=0)
        {
            return dp[W][id];
        }
        int nonTake = helper(W, wt, val, id-1, dp);
        int Take = Integer.MIN_VALUE;
        
        if(wt[id] <= W) Take = val[id] + helper(W-wt[id], wt, val, id-1, dp);
        
        return dp[W][id] = Math.max(Take, nonTake);
    }
}


