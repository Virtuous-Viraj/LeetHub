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
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      obj.convertMinToMaxHeap(n,a);
      for(int e : a)
      {
          System.out.print(e+" ");
      }
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static void convertMinToMaxHeap(int N, int arr[]) {
    // code here
    for(int i = N/2; i>= 0; i--)
    {
        heapify(arr, N, i);
    }
  }
  
    public static void heapify(int[] arr, int n, int i)
    {
        int largest = i;
        int lc = 2*i + 1;
        if(lc<n && arr[lc] > arr[i])
        {
            largest = lc;
        }
        int rc = 2*i + 2;
        if(rc < n && arr[rc] > arr[largest])
        {
            largest = rc;
        }
        if(i != largest)
        {
            swap(arr, i, largest);
            heapify(arr,n, largest);
        }
    }
    
    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
     