//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        
        ArrayList<String> ans = new ArrayList<>();
        // if(s.length()==1)
        // {
        //     ans.add(s);
        //     return ans;
        // }
        helper(s, ans, "");
        Collections.sort(ans);
        return ans;
    }
    
    static void helper(String s, ArrayList<String> ans, String res)
    {
        if(s.length() == 0)
        {
            if(res.length()!=0)ans.add(res);
            return;
        }
      
        // char ch = s.charAt(0);
        // String roq = s.substring(1);
        helper(s.substring(1), ans, res);
        helper(s.substring(1), ans,res+ s.charAt(0));
        
    }
}