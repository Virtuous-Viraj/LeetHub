//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    int countLessThanEqual(int[] arr, int mid)
    {
        int low = 0;
        int high = arr.length-1;
        int total = 0;
        while(low<=high)
        {
            int centre = low + (high-low)/2;
            if(arr[centre]<=mid)
            {
                total = centre + 1;
                low = centre + 1;
            }
            else{
                high = centre - 1;
            }
        }
        return total;
    }
    
    int median(int matrix[][], int R, int C) {
        // code here        
        int r = matrix.length;
        int c = matrix[0].length;
        int start = -1111111111;
        int end = 264243282;
        while(start<=end)
        {
            int mid  = start + (end - start)/2;
            int count = 0;
            for(int i  = 0; i<r; i++)
            {
                count += countLessThanEqual(matrix[i], mid);
            }
            if(count <= (r*c)/2)
            {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return start;
    }
}