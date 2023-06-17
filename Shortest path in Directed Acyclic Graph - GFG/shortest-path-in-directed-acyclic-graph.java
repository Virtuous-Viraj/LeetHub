//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		List<List<Pair>> list = new ArrayList<>();
		
		for(int i   = 0; i<N; i++)
		{
		    List<Pair> ls = new ArrayList<Pair>();
		    list.add(ls);
		}
		for(int i = 0; i<edges.length; i++)
		{
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    list.get(u).add(new Pair(v,wt));
		}
		int vis[] = new int[N];
		Stack<Integer> stk = new Stack<>();
		
		for(int i = 0; i<N; i++)
		{
		    if(vis[i] == 0)
		    {
		        topo(i, list, vis, stk);
		    }
		}
	    int dist[] = new int[N];
	    for(int i = 0; i<N; i++)
	    {
	        dist[i] = (int) 1e9;
	    }
		
		dist[0] = 0;
		while(!stk.isEmpty())
		{
		    int node = stk.pop();
		    
		    for(int i =0 ; i<list.get(node).size(); i++)
		    {
		        int v = list.get(node).get(i).node;
		        int wt = list.get(node).get(i).distance;
		        
		        if(dist[node] + wt < dist[v])
		        {
		            dist[v] = wt + dist[node];
		        }
		    }
		}
		for(int i  = 0 ;i<N; i++)
		{
		    if(dist[i] == 1e9)
		    {
		        dist[i] = -1;
		    }
		}
		return dist;
	}
	
	public static void topo(int node, List<List<Pair>> adj, int[] vis, Stack<Integer> stk)
	{
	    vis[node] = 1;
	    for(int i = 0; i<adj.get(node).size(); i++)
	    {
	        int v = adj.get(node).get(i).node;
	        if(vis[v] == 0)
	        {
	            topo(v, adj, vis, stk);
	        }
	    }
	    stk.add(node);
	}
}

class Pair{
    int node;
    int distance;
    Pair(int node, int distance)
    {
        this.node = node;
        this.distance = distance;
    }
}