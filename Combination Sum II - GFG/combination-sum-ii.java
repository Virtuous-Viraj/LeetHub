//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++) candidates[i] = sc.nextInt();

            Solution obj = new Solution();
            List<List<Integer>> ans = obj.combinationSum2(candidates, k);
            Collections.sort(ans, new Comparator<List<Integer>>() {
                @Override   public int compare(List<Integer> a, List<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            System.out.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.print("]");
            }
            System.out.println(" ]");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(res, ans, a, s, 0, 0);
        return res;
    }
    
    static void helper(List<List<Integer>> res, List<Integer> ans, int[] a,int s, int currSum, int id)
    {
        if(id == a.length)
        {
            if(currSum == s)
            {
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        
        //Take
        if(a[id] + currSum <= s)
        {
            ans.add(a[id]);
            currSum += a[id];
            helper(res, ans,a,s,currSum, id+1);
            currSum -= a[id];
            ans.remove(ans.size()-1);
        }
        
        //skip duplicates
        int i = id;
        while(i<a.length && a[i] == a[id] )
        {
            i++;
        }
        // non take
        helper(res, ans, a, s, currSum, i);
    }
}