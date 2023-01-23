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


class meeting{
    int start;
    int end;
    int pos;
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class meetingComparator implements Comparator<meeting>
{
    public int compare(meeting o1, meeting o2)
    {
        if(o1.end < o2.end) return -1;
        else if(o1.end > o2.end) return 1;
        else if(o1.pos < o1.pos) return -1;
        return 1;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<meeting> meet = new ArrayList<>();
        
        for(int i=0; i<n; i++)
        {
            meet.add(new meeting(start[i],end[i], i+1));
        }
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet,mc);
        ans.add(meet.get(0).pos);
        int currEnd = meet.get(0).end;
        
        for(int i = 1; i<start.length; i++)
        {
            if(meet.get(i).start > currEnd)
            {
                currEnd = meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        return ans.size();
    }
}