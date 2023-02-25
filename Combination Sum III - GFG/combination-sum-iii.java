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

            int K;
            K = sc.nextInt();

            int N;
            N = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.combinationSum(K, N);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
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
            for (int i = 0; i < ans.size(); i++) {
                ArrayList<Integer> cur = ans.get(i);
                for (int j = 0; j < cur.size(); j++) {
                    System.out.print(cur.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum(int k, int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        helper(res, ans, k, n, 1);
        return res;
    }
    
    static void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans, int k, int sum, int id)
    {
        if(id == 10)
        {
            if(sum == 0 && ans.size() == k)
            {
                res.add(new ArrayList<Integer> (ans));
                
            }
            return;
        }
        if(sum == 0 && ans.size() == k)
        {
            res.add(new ArrayList<Integer> (ans));
            return;
        }
            

        //take
        if(id <= sum)
        {
            sum -= id;
            ans.add(id);
            helper(res, ans,k,sum, id+1);
            sum += id;
            ans.remove(ans.size()-1);
        }

        //non take
        helper(res, ans, k, sum, id+1);
    }
}