//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int key = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.binarysearch(arr, n, key));
            T--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int binarysearch(int arr[], int n, int k) {
        // code here
       return helper(arr,0,n-1,k);
    }
    
    public static int helper(int arr[], int start,int end,int k)
    {
        int mid = (start + end)/2;
        while(start<=end)
        {
            if(k<arr[mid])
            {
                return helper(arr,0,mid-1,k);
            }
            else if(k>arr[mid])
            {
                return helper(arr,mid+1,end,k);
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}