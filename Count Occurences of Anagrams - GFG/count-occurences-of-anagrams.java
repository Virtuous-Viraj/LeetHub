//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        HashMap<Character, Integer> map = new HashMap<>();
        int k = pat.length();
        int n = txt.length();
        
        for(int i  = 0 ; i<k; i++)
        {
            map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i),0)+1);
        }
        int ans = 0;
        int count = map.size();
        int i = 0;
        int j = 0;
        while(j<n)
        {
            if(map.containsKey(txt.charAt(j)))
            {
                map.put(txt.charAt(j), map.get(txt.charAt(j))-1);
                if(map.get(txt.charAt(j))==0 || map.get(txt.charAt(j))==null) count--;
                // j++;
            }
            if(j-i+1 <k)
            {
                j++;
            }
            else {
                if(count == 0)
                {
                    ans++;
                }
                if(map.containsKey(txt.charAt(i)))
                {
                    // System.out.print(map.get(txt.charAt(i)));
                    map.put(txt.charAt(i),map.getOrDefault(txt.charAt(i),0)+1);
                       if(map.get(txt.charAt(i))==1)
                        {
                            count++;
                        }
                }
                    i++;
                    j++;   
            }
        }
        return ans;
    }
}