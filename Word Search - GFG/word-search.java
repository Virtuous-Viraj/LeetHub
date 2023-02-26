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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    int di[] = {1,-1,0,0};
    int dj[] = {0,0,-1,1};
    public boolean isWordExist(char[][] board, String word)
    {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i<m; i++)
        {
            for(int j = 0 ;j<n; j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(search(board, word, i, j, 0))
                    {
                        return true;
                    }
                } 
            }
        }
        return false;
    }
    
    boolean search(char[][] board, String word, int i, int j, int k)
    {
        if(k == word.length()) return true;

        if(i<0 || j<0 || i>=board.length || j>= board[0].length || board[i][j] != word.charAt(k) || board[i][j] == '!') return false;

        char ch = board[i][j];
        board[i][j] = '!';
        for(int l = 0 ; l< di.length; l++)
        {
            boolean var = search(board, word, i + di[l], j + dj[l], k+1);
            if(var)
            {
                return true;
            }
        } 
        board[i][j] = ch;
        return false;
    }
}