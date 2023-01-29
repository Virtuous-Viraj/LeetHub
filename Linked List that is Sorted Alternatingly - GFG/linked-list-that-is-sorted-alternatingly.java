//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends


/*
Structure of node class is:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    
   public Node sort(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node nextOfMid = mid.next;
        mid.next = null;
        Node left = sort(head);
        Node right = sort(nextOfMid);
        Node headOfSortedList = merge(left,right);
        return headOfSortedList;
   }

    Node merge(Node m, Node n)
    {
        Node head = new Node(0);
        Node temp = head;
        if (m == null)
            return n;
        if (n == null)
            return m;
 
        while(m!=null && n!=null)
        {
            if(m.data<=n.data)
            {
                head.next = m;
                m = m.next;
            }
            else{
                head.next = n;
                n = n.next;
            }
            head = head.next;
        }
        if (m != null)
            head.next = m;
        if (n != null)
            head.next = n;
        return temp.next;
    }

    public Node getMid(Node head)
    {
        if(head==null) return head;
        Node slow = head;
        Node fast = head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}