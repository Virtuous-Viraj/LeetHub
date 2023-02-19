//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static List<String> generateBinaryStrings(int n) {
    // code here
    ArrayList<String> ans = new ArrayList<>();
    helper(n,ans,"","");
    return ans;
  }
  
    static void helper(int n, ArrayList<String> ans, String prevBit, String res)
    {
        if(n==1)
        {
            if(prevBit == "")
            {
                ans.add("0");
                ans.add("1");
                return;
            }
            if(prevBit =="0")
            {
                String temp1 = res;
                String temp2 = res;
                temp1 += "0";
                temp2 += "1";
                ans.add(temp1);
                ans.add(temp2);
            }
            else{
                res+="0";
                ans.add(res);
            }
            return;
        }
        if(prevBit=="")
        {
            helper(n-1,ans,"0",res + "0");
            helper(n-1,ans,"1",res + "1");     
        }
        if(prevBit=="0")
        {
            // helper(n-1,ans,"0",res + "0");
            helper(n-1,ans,"0",res + "0");
            helper(n-1,ans,"1",res + "1");
        }    
        if(prevBit=="1")
        {
            helper(n-1,ans,"0",res + "0");
        }
    }
}
     
     