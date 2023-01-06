//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        int minrow = 0;
        int maxrow = matrix.length-1;
        int mincol = 0;
        int maxcol = matrix[0].length-1;
        
        int count = 0;
        int total = matrix.length *matrix[0].length;
        
        while(count< total){
            if(count<total)
            for(int j=mincol; j<=maxcol;j++){
                ans.add(matrix[minrow][j]);
                count++;
            }
            
            minrow++;
            if(count<total)
            for(int i=minrow; i<=maxrow;i++){
                ans.add(matrix[i][maxcol]);
                count++;
            }
            maxcol--;
            if(count<total)
            for(int j= maxcol;j>=mincol;j--){
                ans.add(matrix[maxrow][j]);
                count++;
            }
            maxrow--;
            if(count<total)
            for(int i=maxrow; i>=minrow;i--){
                ans.add(matrix[i][mincol]);
                count++;
            }
            
            mincol++;
            
            
           
        }
        
        return ans;
        
    }
}
