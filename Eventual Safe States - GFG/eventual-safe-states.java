//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int[] visited = new int[V];
        int[] pathvisited = new int[V];
        int[] check = new int[V];
        
        for(int i = 0; i<V ; i++)
        {
            if(visited[i] == 0)
            {
                dfs(i, visited, pathvisited, adj, check);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i  = 0 ; i<V; i++)
        {
            if(check[i]!= 0)
            {
                ans.add(i);
            }
        }
        return ans;
    }
    
    public static boolean dfs(int source, int[] visited, int pathvisited[],List<List<Integer>> adj, int[] check)
    {
        visited[source] = 1;
        pathvisited[source] = 1;
        check[source] = 0;
        
        for(int i : adj.get(source))
        {
            if(visited[i] == 0)
            {
                if(dfs(i,visited, pathvisited, adj, check)) 
                {
                    check[source] = 0;
                    return true;
                }
            }
            else if(pathvisited[i] == 1)
            {
                check[source] = 0;
                return true;
            }
        }
        check[source] = 1;
        pathvisited[source] = 0;
        return false;
    }
}
