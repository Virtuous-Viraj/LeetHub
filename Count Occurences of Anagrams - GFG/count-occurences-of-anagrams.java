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
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int n = txt.length(); //total lenght
        int k = pat.length(); //window size
        int ans = 0;
        for(int i = 0; i<k; i++) // insert frequency of every letter into map
        {
            map.put(pat.charAt(i),map.getOrDefault(pat.charAt(i),0)+1);
        }
        // System.out.println(map);
        int count = map.size(); // to avoid iterating over map repeatedly
        int i = 0; //pointers
        int j = 0;
        while(j<n)
        {
            if(map.containsKey(txt.charAt(j)))
            {
                map.put(txt.charAt(j), map.get(txt.charAt(j))-1);
                if(map.get(txt.charAt(j))==null || map.get(txt.charAt(j))==0) count--;   
            }
            if(j-i+1 <k)
            {
                j++;
            }
            else if(j-i+1 == k)
            {
                if(count==0) ans++;
                    if(map.containsKey(txt.charAt(i)))
                    {
                        map.put(txt.charAt(i), map.get(txt.charAt(i))==null? 1 : map.get(txt.charAt(i))+1);
                        if(map.get(txt.charAt(i))==1)
                        {
                            count++;
                        }
                    }                    
                


                
                i++; j++;
            }
            
        }
        return ans;
    }
}