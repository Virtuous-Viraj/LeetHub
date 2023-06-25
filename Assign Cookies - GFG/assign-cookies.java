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
      int m = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int b[] = new int[m];
      for(int i=0;i<m;i++){
        b[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.maxChildren(n, m,a, b);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxChildren(int N,int M,int greed[], int sz[]) {
        Arrays.sort(greed);
        Arrays.sort(sz);
        int content = 0;
        int i = 0;
        int j = 0;
        while(i<greed.length && j < sz.length)
        {
            if(greed[i] <= sz[j])
            {
                content++;
                i++;
                j++;
            }
            // else if(g[i] > s[j])
            // {
            //     j++;
            // }
            else{
                j++;
            }
        }
        return content;
  }
}
     