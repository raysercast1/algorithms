package Leetcode.TreesAndGraphs.DepthFirstSearch;

public class MaxDepth {
     public static class Node {
        int val;
        Node left;
        Node right;

        Node() {}

        Node (int val) {
            this.val = val;
        }

        Node (int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
     }

      static public void main(String[] args) {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        zero.left = one;
        zero.right = two;
        one.left = three;
        one.right = four;
        four.right = six;
        two.right = five;

        int ans = maxDepth(zero);
        System.out.println("Printing Answer: ");
        System.out.println(ans);   
      }

     static private int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        System.out.println("Root value is:");
        System.out.println(root.val);
        System.out.println("Max.max is");
        int ans = Math.min(left, right) + 1;
        System.out.println(ans);

        return ans;
     } 
       
   
 }

