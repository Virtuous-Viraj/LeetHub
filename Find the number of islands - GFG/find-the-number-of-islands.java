//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        int count = 0;
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0; j<grid[0].length; j++)
            {
                if(visited[i][j]==0 && grid[i][j]=='1')
                {
                    count++;
                    dfs(visited, grid,  i,  j);
                }
            }
        }
        return count;
    }
    
    static void dfs(int[][] visited, char grid[][], int row, int col)
    {
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        for(int i = -1 ; i<2 ; i++)
        {
            for(int j = -1; j<2; j++)
            {
                int newRow = row + i; 
                int newCol = col + j;
                if(newRow>=0 && newRow <n && newCol<m && newCol>=0 && visited[newRow][newCol]!=1 && grid[newRow][newCol]=='1')
                {
                    dfs(visited, grid, newRow, newCol);
                }
            }
        }
    }
}