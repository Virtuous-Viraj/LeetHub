//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] prices) {
        // code here
        int dp[][][] = new int[n+1][2][3];
        return helper(prices,0,1,2,n,dp);
    }
    
    private static int helper(int[] prices, int ind, int buy, int cap, int n,int[][][] dp)
    {
        if(cap==0) return 0;
        if(ind==n) return 0;
        
        for(int i = n-1; i>=0; i--)
        {
            for(int b = 0; b<=1; b++)
            {
                for(int c = 1; c<=2; c++)
                {
                        if(b==1)
                        {
                                 dp[i][b][c] = Math.max(-prices[i]+dp[i+1][0][c],dp[i+1][1][c]);
                        }
                        else{
                                 dp[i][b][c] = Math.max(prices[i]+dp[i+1][1][c-1],0+dp[i+1][0][c]);
                        }
                }
            }
        }
        return dp[0][1][2];
        
        // if(dp[ind][buy][cap]!=0) return dp[ind][buy][cap];
        // if(buy==1)
        // {
        //         return dp[ind][buy][cap] = Math.max(-prices[ind]+helper(prices,ind+1,0,cap,n,dp),0+helper(prices,ind+1,1,cap,n,dp));
        // }
        // else{
        //         return dp[ind][buy][cap] = Math.max(prices[ind]+helper(prices,ind+1,1,cap-1,n,dp),0+helper(prices,ind+1,0,cap,n,dp));
        // }
    }
}
        
