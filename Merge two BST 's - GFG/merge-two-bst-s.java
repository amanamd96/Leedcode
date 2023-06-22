//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution T = new Solution();
            List<Integer> ans = T.merge(root1,root2);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    
    void inorder(Node root , ArrayList<Integer> arr){
        if(root == null){
            return ;
        }
        inorder(root.left , arr);
        arr.add(root.data);
        inorder(root.right , arr);
    }
    
    // create BST
    public Node createBST(ArrayList<Integer> arr , int start , int end){
        
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr , start , mid - 1);
        root.right = createBST(arr , mid+1 , end);
        
        return root;
    }
    
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        //inorder bst 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        inorder(root1 , arr1);
        
        ArrayList<Integer> arr2 = new ArrayList<>();
        inorder(root2 , arr2);
        
        // merge
        int i=0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i < arr1.size() && j<  arr2.size() ){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        
        while(i < arr1.size()){
              finalArr.add(arr1.get(i));
                i++;
        }
        
        while(j < arr2.size()){
             finalArr.add(arr2.get(j));
             j++;
        }
        
        return finalArr;
        }
}
