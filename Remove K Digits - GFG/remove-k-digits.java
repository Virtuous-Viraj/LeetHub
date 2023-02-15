//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder str = new StringBuilder("");
        int n = num.length();
        Stack<Character> s = new Stack<>();

        for(int i = 0; i<n; i++)
        {
            // peak element is that element which will be greater than current character so pop it and k--
            while(!s.isEmpty() && k>0 && s.peek()>num.charAt(i))
            {
                s.pop();
                k--;
            }
            if(!s.isEmpty() || num.charAt(i)!='0')
            {
                s.push(num.charAt(i));
            }
        }
        while(!s.isEmpty() && k-->0)
        {
            s.pop();
        }
        while(!s.isEmpty())
        {
            str = str.append(s.pop()) ;
        }
        str = str.reverse();
        while (!s.isEmpty() && str.charAt(0) == '0') {
            if (str.length() > 1)
                str = new StringBuilder(str.substring(1));
            else str = new StringBuilder("");
        }

        if (str.length() == 0) return "0";
        return str.toString();
    }
}