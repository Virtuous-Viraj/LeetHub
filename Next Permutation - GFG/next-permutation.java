//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    private static void reverse(int nums[], int i, int j)
    {
        while(i <= j)
        {
            swap(nums, i , j);
            i++;
            j--;
        }
    }

    private static void swap(int nums[], int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    static List<Integer> nextPermutation(int N, int nums[]){
        ArrayList<Integer> ans = new ArrayList<>();
        
        int n = nums.length;
        // find the breakpoint
        int index = -1;
        for(int i = n-2; i>= 0; i--)
        {
            if(nums[i] < nums[i+1])
            {
                index = i;
                break;
            }
        }
        if(index == -1)
        {
            reverse(nums, 0, n-1);
            for(int i : nums)
            {
                ans.add(i);
            }
            return ans;
        }
        // find someone just greater than the breakpoint and swap it

        for(int i = n-1; i>index; i--)
        {
            if(nums[i] > nums[index])
            {
                swap(nums, i, index);
                break;
            }
        }

        reverse(nums, index+1, n-1);
        for(int i : nums)
        {
            ans.add(i);
        }
        return ans;
    }
}