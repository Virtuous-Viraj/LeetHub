//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {   
        if(N<M) return -1;
        //Your code here
        int start = Integer.MIN_VALUE;
        int end = 0;
        for(int i = 0; i<N; i++)
        {
            start = Math.max(start,A[i]);
            end += A[i];
        }
        
        return helper(A,N,M,start,end);
    }
    
    static int helper(int arr[], int n, int number, int start, int end)
    {
        int res = -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(isValid(arr,n,number,mid))
            {
                res = mid;
                end = mid-1; 
            }
            else{
                start = mid + 1;
            }
            
        }
        return res;
    }
    
    static boolean isValid(int[] arr, int n, int number, int max)
    {
        int students = 1;
        int sum = 0;
        for(int i = 0; i<n; i++)
        {
            sum += arr[i];
            if(sum>max)
            {
                students++;
                sum = arr[i];
            }
        }
        if(students>number)
        {
            return false;
        }
        return true;
    }
};