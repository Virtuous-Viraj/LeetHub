//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] nums, int n, int target) {
        // code here
        n = n-1;
        int first = helperFirst(nums,target,0,n);
        int last = helperLast(nums,target,0,n);
        if(first==-1 && last==-1) return 0;
        return last - first + 1;
    }
    int helperFirst(int[] nums, int target, int start, int end)
    {
        int first = -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(target < nums[mid])
            {
                end = mid - 1;
            }
            else if(target > nums[mid])
            {
                start = mid + 1;
            }
            else{
                first = mid;
                end = mid - 1;
            }
        }
        return first;
    }

    int helperLast(int[] nums, int target, int start, int end)
    {
        int last = -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(target < nums[mid])
            {
                end = mid - 1;
            }
            else if(target > nums[mid])
            {
                start = mid + 1;
            }
            else{
                last = mid;
                start = mid + 1;
            }
        }
        return last;
    }
}