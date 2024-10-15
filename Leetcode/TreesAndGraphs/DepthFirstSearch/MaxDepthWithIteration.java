package Leetcode.TreesAndGraphs.DepthFirstSearch;

import java.util.Stack;

public class MaxDepthWithIteration {
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

    
      public static class Pair {
        Node node;
        int depth;
        Pair(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
      }

    //Runtime O(n) since every op inside the loop is O(1). If op is O(k) then runtime will be O(n times k);
    //Space complexity O(n);
     static private int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

       Stack<Pair> stack = new Stack<>(); 
       stack.push(new Pair(root, 1));
       int ans = 0;
      //In this case, we're checking the right node first. Since it's the last node in the stack 
      while (!stack.empty()) {
          Pair pair = stack.pop();
          Node node = pair.node;
          int depth = pair.depth;
          System.out.println("The current node val is: ");
          System.out.println(node.val);

          ans = Math.max(ans, depth);
          if (node.left != null) {
            stack.push(new Pair(node.left, depth + 1));
          }

          if (node.right != null) {
            stack.push(new Pair(node.right, depth + 1));
          }
        
      }
       return ans;
     } 
}
