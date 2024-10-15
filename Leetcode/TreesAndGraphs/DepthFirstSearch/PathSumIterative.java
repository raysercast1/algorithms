package Leetcode.TreesAndGraphs.DepthFirstSearch;

import java.util.Stack;

public class PathSumIterative {
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

   public static void main(String[] args) {
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
  
          boolean ans = pathSumCheck(zero);
          System.out.println("Ans is: ");
          System.out.println(ans);
  
      }
     

     private static class Pair {
        Node node;
        int curr;

        Pair(Node node, int curr) {
            this.node = node;
            this.curr = curr;
        }
     }
      


      private static boolean pathSumCheck(Node root) {
        if (root == null) {
            return false;
        }  

        Stack<Pair> stack = new Stack<>();
        
        stack.push(new Pair(root, 0));

        while(!stack.empty()) {
           Pair pair = stack.pop();
           Node node = pair.node;
           int curr = pair.curr;

          if (node.left == null && node.right == null) {
            return curr + node.val == 7;
          } 

            curr += node.val;
            if (node.left != null) {
                stack.push(new Pair(node.left, curr));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, curr));
            }
        }
        
        return false;
      }
 }
