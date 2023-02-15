//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int matrix[][], int n, int m) {
        int maxA = Integer.MIN_VALUE;
        int[] prev = new int[matrix[0].length];
        for(int i = 0; i< matrix.length; i++)
        {
            int[] curr = new int[matrix[0].length];
            for(int j = 0; j<matrix[0].length; j++)
            {   
                if(matrix[i][j] == 0) continue;
                curr[j] = prev[j] + (matrix[i][j]); 
            }
            maxA = Math.max(maxA, largestRectangleArea(curr));
            prev = curr;
        }
        return maxA;
    }
    
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int leftBoundry[] = new int[n]; //to store the left boundry (left smaller)
        int rightBoundry[] = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0); 
        for(int i = 1; i<n; i++)
        {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i] )
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                leftBoundry[i] = 0;
            }
            else{
                leftBoundry[i] = s.peek() + 1;
            }
            s.push(i);
        }   
        s.clear();
        rightBoundry[n-1] = n-1;
        s.push(n-1);
        for(int i = n-2; i>=0; i--)
        {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                rightBoundry[i] = n-1;
            }
            else{
                rightBoundry[i] = s.peek() - 1;
            }
            s.push(i);
        }
        int maxArea = 0;
        for(int i = 0; i<heights.length; i++)
        {
            int area = heights[i] * (rightBoundry[i] - leftBoundry[i] + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}