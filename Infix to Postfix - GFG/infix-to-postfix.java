//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        String res = "";
        Stack<Character> s = new Stack<>();
        int i = 0;
        int n = exp.length();
        
        while(i<n)
        {
            char c = exp.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
            || (c >= '0' && c <= '9'))
            {
                res += c;
            }
            else if(c == '(')
            {
                s.push(c);
            }
            else if(c == ')')
            {
                while(!s.isEmpty() && s.peek()!='(')
                {
                    res += s.peek();
                    s.pop();
                }
                if(!s.isEmpty()) s.pop();
            }
            else{
                while(!s.isEmpty() && (prec(c) <= prec(s.peek())))
                {
                    res += s.peek();
                    s.pop();
                }
                s.push(c);
            }
            i++;
        }
        while(!s.isEmpty())
        {
            res += s.peek();
            s.pop();
        }
        return res;
        
    }
    
    public static int prec(char ch)
    {
        if(ch=='+' || ch=='-') return 1;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='^') return 3;
        return -1;
    }
}