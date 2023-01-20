//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int[] nums, int l, int h, int target)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
                int n = nums.length;
        int index = helper(nums,target,0,n-1,n);
        // System.out.println(index);
        int leftHalf = binaryS(nums,0,index-1,target);
        int rightHalf = binaryS(nums,index,nums.length-1,target);
        // System.out.println(rightHalf);
        if(leftHalf == -1 && rightHalf == -1) return -1;
        else return leftHalf == -1? rightHalf : leftHalf;
    }
    
    int binaryS(int[] nums, int start, int end, int target)
    {
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid]<target)
            {
                start = mid + 1;
            }
            else if(nums[mid]>target)
            {
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    int helper(int[] nums, int target, int start, int end, int n)
    {
            while(start<=end)
            {
                int mid = start + (end-start)/2;
                int next = (mid+1)%n;
                int prev = (mid+n-1)%n;
                if(nums[mid]<=nums[next] && nums[mid]<=nums[prev])
                {
                    return mid;
                }
                else if(nums[0]<=nums[mid])
                {
                    start = mid + 1;
                }
                else 
                {
                    end = mid - 1;
                }
            }
            return 0;
    }
}