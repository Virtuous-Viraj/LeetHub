//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        int[][] vis = new int[n][m];
        int freshCount = 0;
        int count = 0;
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                // if orange is rotten
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j]==1) freshCount++;
            }
        }
        int time = 0;
        int di[] = {-1, 0, 1, 0};
        int dj[] = {0, 1, 0,-1 };
        while(!q.isEmpty())
        {
            int row = q.peek().row;
            int col = q.peek().col;
            int t = q.peek().time;
            time = Math.max(t, time);
            q.poll();
            for(int i = 0; i<4; i++)
            {
                    int newRow = row + di[i];
                    int newCol = col + dj[i];
                    if(newRow>=0 && newRow <n && newCol<m && newCol>=0 && vis[newRow][newCol]==0 && grid[newRow][newCol]==1)
                    {
                        q.offer(new Pair(newRow, newCol, t+1));
                        vis[newRow][newCol] = 2;
                        count++;
                    }
            }
        }   
        if(freshCount != count) return -1;
        return time;
    }
}

class Pair{
    int row;
    int col;
    int time;
    
    Pair(int row, int col, int time)
    {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
