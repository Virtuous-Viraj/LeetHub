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
		//Code here
		List<List<Pair>> adj = new ArrayList<>();
		for(int i  = 0 ; i<N; i++)
		{
		    List<Pair> l = new ArrayList<Pair>();
		    adj.add(l);   
		}
		for(int i = 0; i<M; i++)
		{
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    
		    adj.get(u).add(new Pair(v, wt));
		    
		}
		Stack<Integer> stk = new Stack<>();
		int vis[] = new int[N];
		for(int i=  0; i<N; i++)
		{
		    if(vis[i] == 0)
		    {
		        topo(i, vis, adj,stk);
		    }
		}
		int dist[] = new int[N];
		for(int i =  0; i<N; i++)
		{
		    dist[i] = (int)(1e9);
		}
		dist[0] = 0;
		while(!stk.isEmpty())
		{
		    int node = stk.pop();
		    for(int i = 0; i<adj.get(node).size(); i++)
		    {
		        int v = adj.get(node).get(i).node;
		        int wt = adj.get(node).get(i).distance;
		        if(dist[node] + wt < dist[v])
		        {
		            dist[v] = dist[node] + wt;
		        }
		    }
		}
		for(int i = 0; i<N; i++)
		{
		    if(dist[i] == (1e9)) dist[i] = -1;
		}
		return dist;
	}
	
	public void topo(int node, int[] vis,List<List<Pair>> adj , Stack<Integer> stk)
	{
	    vis[node] = 1;
	    for(int i = 0; i<adj.get(node).size(); i++)
	    {
	        int t = adj.get(node).get(i).node;
	        if(vis[t] == 0)
	        {
	            topo(t, vis, adj, stk);
	        }
	    }
	    stk.push(node);
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