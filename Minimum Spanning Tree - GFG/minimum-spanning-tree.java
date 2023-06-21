//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	   // int n = edges.length;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            adj.get(u).add(new ArrayList<>(Arrays.asList(v, weight)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u, weight)));
        }

	    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.weight - y.weight);
	    int vis[] = new int[V];
	    int sum = 0;
	    pq.offer(new Pair(0,0));
	    
	    while(!pq.isEmpty())
	    {
	        int node = pq.peek().node;
	        int wt = pq.peek().weight;
	        pq.poll();
	        if(vis[node] == 1) continue;
	        vis[node] = 1;
	        sum += wt;
	        for(int i = 0; i< adj.get(node).size(); i++)
	        {
	            int adjNode = adj.get(node).get(i).get(0);
	            int edgeWeight = adj.get(node).get(i).get(1);
	            if(vis[adjNode] == 0)
	            {
	                pq.offer(new Pair(adjNode,edgeWeight));
	            }
	        }
	    }
	    return sum;
	}
}
class Pair{
    int node;
    int weight;
    Pair(int node, int weight)
    {
        this.node = node;
        this.weight = weight;
    }
}