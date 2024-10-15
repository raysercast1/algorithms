package Leetcode.TreesAndGraphs.BinarySearchTree;

import java.util.Stack;

public class InsertIntoBST {
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
        Node twenty = new Node(20);
        
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

        Node ans = insertIntoBST(ten, twenty.val);
        System.out.println("New Tree are");

        Stack<Node> stack = new Stack<>();
        stack.push(ten);
        while (!stack.empty()) {
            Node n = stack.pop();
            
            System.out.printf("Values of BTree with inserted node is: %d%n", n.val);

            if (n.left != null) stack.push(n.left);
            if (n.right != null) stack.push(n.right); 
        }

      }
 
    //TODO Fix: When it's a leaf node the algoritms is inserting the new node twice. This is because it first inserts
    //the new node in lines 72-78 then insert it again from 81-87.
    private static Node insertIntoBST(Node root, int val) {
        if (root == null) return root;

        if (root.left == null && root.right == null) {
            if (val > root.val) {
                root.right = new Node(val);
            } else {
                root.left =  new Node(val);
            }
        }

        if (val > root.val && root.right == null) {
            root.right = new Node(val);
        }

        if (val < root.val && root.left == null) {
            root.left = new Node(val);
        }

        if (val > root.val && root.right != null) {
            insertIntoBST(root.right, val);
        }

        if (val < root.val && root.left != null) {
            insertIntoBST(root.left, val);
        }

        return root;
    }
}
