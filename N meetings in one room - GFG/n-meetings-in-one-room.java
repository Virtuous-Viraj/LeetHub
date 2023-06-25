//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class myComparator implements Comparator<Meeting>{
    public int compare(Meeting m, Meeting n)
    {
        if(m.end < n.end) return -1;
        else if(m.end > n.end) return 1;
        else if(m.pos < n.pos) return -1;
        return 1;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Meeting> list = new ArrayList<>();
        for(int i = 0; i<start.length; i++)
        {
            list.add(new Meeting(start[i], end[i], i+1));
        }
        Collections.sort(list, new myComparator());
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(list.get(0).pos);
        int endTime = list.get(0).end;
        
        for(int i =1; i<start.length; i++)
        {
            if(list.get(i).start > endTime)
            {
                endTime = list.get(i).end;
                ans.add(list.get(i).start);
            }
        }
        
        return ans.size();
    }
}
class Meeting{
 int start;
 int end;
 int pos;
 Meeting(int start, int end, int pos)
 {
     this.start = start;
     this.end = end;
     this.pos = pos;
 }
}
