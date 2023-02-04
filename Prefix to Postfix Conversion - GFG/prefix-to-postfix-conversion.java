//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToPost(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String pre) {
        Stack<String>stack=new Stack<>();
        for(int i=pre.length()-1;i>=0;i--){
            char c=pre.charAt(i);
            
            if((c>=97&&c<=122)||(c>=65&&c<=90)){stack.push(c+"");}
            else {
                String a=stack.pop();
                String b=stack.pop();
                stack.push(a+""+""+b+c);
                
            }
        }
        return stack.pop();   
    }
}
