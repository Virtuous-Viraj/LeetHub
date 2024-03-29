//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
        private static Node mapParents(Node root, HashMap<Node, Node> map, int start)
    {
        Queue<Node> q = new LinkedList<>();
        Node found = new Node(0);
        q.offer(root);
        while(!q.isEmpty())
        {

            Node curr = q.poll();
            if(curr.data == start) found = curr;
                if(curr.left!=null)
                {
                    map.put(curr.left,curr);
                    q.offer(curr.left);
                }
                if(curr.right!=null)
                {
                    map.put(curr.right,curr);
                    q.offer(curr.right);
                }
        }
        return found;
    }
    private static int findMin(HashMap<Node, Node> map,Node target)
    {
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int time = 0;
        while(!q.isEmpty())
        {
            int lvl = q.size();
            boolean isBurned = false;
            for(int i = 0; i<lvl; i++)
            {
                Node curr = q.poll();
                if(curr.left!=null && visited.get(curr.left)==null)
                {
                    isBurned = true;
                    visited.put(curr.left,true);
                    q.offer(curr.left);
                }
                if(curr.right!=null && visited.get(curr.right)==null)
                {
                    isBurned = true;
                    visited.put(curr.right,true);
                    q.offer(curr.right);
                }
                if(map.get(curr)!=null && visited.get(map.get(curr))==null)
                {
                    isBurned = true;
                    visited.put(map.get(curr),true);
                    q.offer(map.get(curr));
                }
            }
            if(isBurned) time++; // koi bhi node jala nahi to time mat badhao bhai
        }
        return time;
    }
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
    HashMap<Node, Node> map = new HashMap<>();
        Node tar = mapParents(root,map,target);
//            System.out.println(map);
        int time = findMin(map,tar);
        return time;
    }
    
}