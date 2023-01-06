//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int nums[])
    {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        int len = 1;
        for(int i = 1; i<n; i++)
        {
            if(nums[i]>ans.get(ans.size()-1))
            {
                ans.add(nums[i]);
                len++;
            }
            else{
                int ind = lower_bound(ans,nums[i]);
                ans.set(ind,nums[i]);
            }
        }
        return len;
    }

private static int lower_bound(ArrayList<Integer> array, int key)
    {
        int low = 0, high = array.size();
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (key <= array.get(mid)) {
                high = mid;
            }
            else {
 
                low = mid + 1;
            }
        }
        if (low < array.size() && array.get(low) < key) {
            low++;
        }
        return low;
}
} 