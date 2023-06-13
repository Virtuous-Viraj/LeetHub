//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int numCourses, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i  = 0; i<numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> topo = new ArrayList<>();
        for(int i = 0 ; i<prerequisites.length; i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegree = new int[numCourses];
        for(int i= 0; i<numCourses; i++)
        {
            for(int j : adj.get(i))
            {
                indegree[j]++;
            }
        }
        for(int i = 0; i<numCourses; i++)
        {
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty())
        {
            int node = q.poll();
            topo.add(node);
            for(int i : adj.get(node))
            {
                indegree[i]--;
                if(indegree[i] == 0) q.offer(i);
            }
        }
        return topo.size() == numCourses;
    }
    
}