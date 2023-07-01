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
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.maxScore(a, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static long maxScore(int cardPoints[], int N, int k) {
        // code here
        int totalSum = 0;
        for (int card : cardPoints) {
            totalSum += card;
        }
        int n = cardPoints.length;
        int newW = n - k;
        int sum = 0;
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while(j<n)
        {
            sum += cardPoints[j];

            if(j-i+1 > newW)
            {
                sum -= cardPoints[i];
                i++;
            }
            if(j-i+1 == newW)
            {
                min = Math.min(min,sum);
            }
            j++;
        }  
        return totalSum - min;
    }
}
