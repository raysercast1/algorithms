package Leetcode.TreesAndGraphs.BinarySearchTree;

import java.util.Stack;

public class RangeSumBST {
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
        Node three = new Node(3);
        Node five = new Node(5);
        Node seven = new Node(7);
        Node ten = new Node(10);
        Node fifthteen = new Node(15);
        Node eithteen = new Node(18);
        
        /*
        10
      /    \ 
     5      15
   /  \       \
  3    7       18 
          */

        ten.left = five;
        ten.right = fifthteen;
        five.left = three;
        five.right = seven;
        fifthteen.right = eithteen;

        int ans = rangeSumBST(ten, 7, 15);
        System.out.printf("Sum of range is: %d%n", ans);
        System.out.println("The node btw the range are: 10 - 7 - 15");

        int ans2 = rangeSumBSTIterative(ten);
        System.out.printf("Iterative ans: %d%n", ans2);
      }
        
      //O(n) time and space complexity.
      //on average this algorithm will perform better than simply searching all nodes.
      //e.g.;if you had a full tree with a million nodes, and the root's value was greater than high, then you can immediately 
      //save 500,000 visits based on the logic that all nodes in the right subtree are greater than 
      //the root's value which is already outside the range.
      private static int rangeSumBST(Node root, int low, int high) {
          if (root == null) return 0;

          int ans = 0;

          //If the node is btw the range add it to the sum
          if (low <= root.val && root.val <= high) {
            ans += root.val;
          }

          //If current node val is greater than 'low' it means that we can still find a smaller node in the left side.
          //If not then there's no point in going to the left.
          if (low < root.val) {
            ans += rangeSumBST(root.left, low, high);
          }

          //If current node val is less than 'high' it means that we can still find a greater node in the right side.
          //If not then there's no point in going to the right.
          if (high > root.val) {
            ans += rangeSumBST(root.right, low, high);
          }

          //returing the final sum
          return ans;
      }

      private static int rangeSumBSTIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int ans = 0;

        while (!stack.empty()) {
            Node n = stack.pop();
            
            if (7 <= n.val && n.val <= 15) {
                ans += n.val;
            }

            if (n.left != null && n.val > 7) {
                stack.push(n.left);
            }

            if (n.right != null && n.val < 15) {
                stack.push(n.right);
            }
        }
        return ans;
      }
}
