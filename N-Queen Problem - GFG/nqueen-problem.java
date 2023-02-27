//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        String[][] board = new String[n][n];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                board[i][j] = ".";
            }
        }
        helper(0, board, res, n);
        return res;
    }
    
    static void helper(int col, String[][] board, ArrayList<ArrayList<Integer>> res, int n)
    {
        if(col == n)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i<n; i++)
            {
                // StringBuilder s = new StringBuilder("");
                for(int j = 0; j<n; j++)
                {
                    if(board[j][i] == "Q")
                    {
                        temp.add(j+1);
                    }
                }
                // temp.add(s.toString());
            }
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int row = 0; row<n; row++)
        {
            if(isSafe(board, row, col,n))
            {
                board[row][col] = "Q";
                helper(col+1, board, res, n);
                board[row][col] = ".";
            }
        }
    }

    static boolean isSafe(String[][] board, int row, int col, int n)
    {
        int storeRow  = row;
        int storeCol = col;

        //check upper right diagonal
        while(row>=0 && col>=0)
        {
            if(board[row][col] =="Q") return false;
            row--; col--;
        }
        row = storeRow;
        col = storeCol;
        //check left
        while(col>=0)
        {
            if(board[row][col] == "Q") return false;
            col--;
        }
        //lower right diagonal
        row = storeRow;
        col = storeCol;
        while(col>=0 && row<n)
        {
            if(board[row][col] == "Q") return false;
            col--;
            row++;
        }
        return true;
    }
}