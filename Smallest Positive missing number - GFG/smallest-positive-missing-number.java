//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution
{
    static int missingNumber(int arr[], int size)
    {
        int n = arr.length;
        for(int i = 0; i < n; i++)
        {
            while(arr[i] > 0 && arr[i] <= n && arr[arr[i]-1] != arr[i]) swap(arr,arr[i]-1,i);
        }
        int num = 1;
        for(int i = 0; i<arr.length; i++)
        {
            if(arr[i] != i+1) return i+1;
        }
        return n+1;
        
    }
    
    static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}


// } Driver Code Ends