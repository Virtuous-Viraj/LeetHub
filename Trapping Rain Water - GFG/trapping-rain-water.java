//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        if(n < 3) return 0;
        int maxLeft = arr[0];
        int maxRight = arr[n-1];
        long water = 0;
        int left = 1;
        int right = n-2;
        
        while(left <= right)
        {
            if(maxLeft < maxRight)
            {
                if(arr[left] > maxLeft)
                {
                    maxLeft = arr[left];
                }
                else{
                    water += maxLeft - arr[left];
                    left++;
                }
            }
            else
            {
                if(arr[right] > maxRight)
                {
                    maxRight = arr[right];
                }
                else{
                    water += maxRight - arr[right];
                    right--;
                }
            }
        }
        return water;
    } 
}


