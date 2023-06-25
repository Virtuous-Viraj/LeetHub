//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer>minHeap = new PriorityQueue<>();
    //Function to insert heap.
    public static void insertHeap(int num)
    {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.add(num);
        else
            minHeap.add(num);

        if(maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
        else if( maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(maxHeap.size() == minHeap.size())
        {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }
    
}