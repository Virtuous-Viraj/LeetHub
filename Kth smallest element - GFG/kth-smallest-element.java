//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        // int pivot = arr[r];
        int pi = partition(arr,l,r);
        if(k-1 > pi)
        {
            return kthSmallest(arr,pi+1, r, k);
        }
        else if(k-1 < pi)
        {
            return kthSmallest(arr, l, pi-1, k );
        }
        else{
            return arr[pi];
        }
        // return -1;
    }
    
    static int partition(int arr[], int low, int high)
    {
            int pivot = arr[high];
            int i = low-1;
            for(int j = low; j<high; j++)
            {
                if(arr[j] < pivot)
                {
                    i++;
                    swap(arr,i,j);
                }
            }
            swap(arr,i+1,high);
            return i+1;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
