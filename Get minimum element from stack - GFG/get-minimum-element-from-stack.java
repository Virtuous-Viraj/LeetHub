//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
class GfG
{
    int minEle;
    Stack<Pair> s;
    
    GfG()
    {
        s = new Stack<Pair>();
    }
    /*returns min element from stack*/
    int getMin()
    {
           if(!s.isEmpty()) return s.peek().second;
           return -1; 
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here
	    if(s.isEmpty()) return -1;
	    return s.pop().first;
    }

    /*push element x into the stack*/
    void push(int val)
    {
	s.push(new Pair(val, Math.min(val,s.isEmpty()? val : s.peek().second )));	
    }	
}

