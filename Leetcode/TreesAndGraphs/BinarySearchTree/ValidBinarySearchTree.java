package Leetcode.TreesAndGraphs.BinarySearchTree;

import java.util.Stack;

public class ValidBinarySearchTree {
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
[-inf,10)       10   (10,inf]
              /    \ 
[-inf,5)     5      15   (15,inf]
           /  \       \
[-inf,3)  3    7       18   (18,inf]
             (5,10)        */

        ten.left = five;
        ten.right = fifthteen;
        five.left = three;
        five.right = seven;
        fifthteen.right = eithteen;

        boolean ans = isValidBST(ten);
        System.out.printf("Recursively: ans: %b%n", ans);

        boolean ans2 = isValidBSTIterative(ten);
        System.out.printf("Iterative: ans: %b%n", ans);
      }


      private static boolean isValidBST(Node root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
      }
      
      //O(n) time and space complexity
      private static boolean dfs(Node n, long sm, long lg) {
        //By definition one single node is a BST.
        if (n == null) return true;

        //Validate if the BST rule is violated.
        if (sm >= n.val || n.val >= lg) return false;
        
        //    (left n < parent < right n).
        // Adding the constraint of BST (-infinity, n.val).
        boolean left = dfs(n.left, sm, n.val);

        //   (left n < parent < right n).
        // Adding the constraint of BST (n.val, infinity).
        boolean right = dfs(n.right, n.val, lg);

        return left && right;
      }

      //O(n) time and space complexity
      private static boolean isValidBSTIterative(Node root) {
        Stack<State> stack = new Stack<>();
        stack.push(new State(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!stack.empty()) {
            State state = stack.pop();
            Node n = state.node;
            long sm = state.small;
            long lg = state.large;

            if (sm >= n.val || n.val >= lg ) return false;

            if (n.left != null) stack.push(new State(n.left, sm, n.val));

            if (n.right != null) stack.push(new State(n.right, n.val, lg));
        }

        return true;
      }

      private static class State {
        Node node;
        long small;
        long large;

        State(Node n, long sm, long lg) {
            this.node = n;
            this.small = sm;
            this.large = lg;
        }
      }
}
