//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> ans = new ArrayList<>();
        helper(ans, n, n, "");
        return ans;
    }
    
    static void helper(List<String> ans, int open, int close, String res)
    {
        if(open ==0 && close == 0)
        {
            ans.add(res);
            return;
        }
        
        if(open!=0)
        {
            helper(ans, open-1, close, res+"(");
        }
        if(close>open)
        {
            helper(ans, open, close-1, res+")");
        }
    }
    
    
}