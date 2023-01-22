//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        if(n>m) return medianOfArrays(m,n,b,a);
        
        int low = 0;
        int high = n;
        
        while(low<=high)
        {
        int m1 = (low+high)/2;
        int m2 = (m+n+1)/2 - m1;
        
        int min1 = (m1==n)?  Integer.MAX_VALUE : a[m1];
        int min2 = (m2==m)?  Integer.MAX_VALUE : b[m2];
        
        int max1 = (m1==0)?  Integer.MIN_VALUE : a[m1-1];
        int max2 = (m2==0)? Integer.MIN_VALUE : b[m2-1];
        
        if(max1<=min2 && max2<=min1)
        {
            if((n+m)%2==0)
            {
                return (Math.max(max1, max2)+Math.min(min1, min2))/2.0;
            }
            else{
                return Math.max(max1, max2);
            }
        }
        else if(max1>min2)
        {
            high = m1 - 1;
        }
        else{
            low = m1 + 1;
        }
        }
        return 0.0;
    }
}