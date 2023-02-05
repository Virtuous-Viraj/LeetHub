//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG
{
    public static void main (String[] args)
	{
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            
            int tree[]= new int[n];
            for(int i=0; i<n; i++)
                tree[i] = in.nextInt();
            int k = in.nextInt();
            
            Solution x = new Solution();
            System.out.println( x.find_height(tree,n,k) );
        }
	}
}
// } Driver Code Ends


class Solution
{
    static int find_height(int A[], int n, int B)
    {
        Arrays.sort(A);
        return helper(A, B);
    }
    
    static int countwood(int[] A, int k )
    {
        int wood = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<A.length; i++)
        {
            if(A[i]>k)
            {
             wood += A[i] - k;   
            }
        }
        return wood;
    } 
    static int helper(int[] A , int B )
    {
        
        int low = 0;
        int high = A[A.length-1];
        
        while(low<= high)
        {
            int mid = low + (high - low)/2;
            
            if(countwood(A,mid)==B)
            {
                return mid;
            }
            else if(countwood(A,mid)<B)
            {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
