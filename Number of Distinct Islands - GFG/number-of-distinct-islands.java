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
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int visited[][] = new int[m][n];
        Set<List<String>> s = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, i, j, grid, visited, list, m, n);
                    s.add(list);
                }
            }
        }
        // System.out.println(s);
        return s.size();
    }
    
    public static void dfs(int row, int col, int brow, int bcol, int[][] grid, int[][] visited, ArrayList<String> list, int m, int n) {
        visited[row][col] = 1;
        StringBuilder str = new StringBuilder("");
        str.append(row-brow);
        str.append(col-bcol);
        list.add(str.toString());
        
        int drow[] = {0, 1, 0, -1};
        int dcol[] = {1, 0, -1, 0};
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + drow[i];
            int newCol = col + dcol[i];
            
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol, brow, bcol, grid, visited, list, m, n);
            }
        }
    }
}

class Pair {
    int row;
    int col;
    
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
