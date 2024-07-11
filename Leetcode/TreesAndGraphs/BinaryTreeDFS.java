package Leetcode.TreesAndGraphs;

public class BinaryTreeDFS {
    public static void main(String[] args) {
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        zero.left = one;
        zero.right = two;
        one.left = three;
        one.right = four;
        four.right = six; 
        two.right = five;

        /* The name of each traversal is describing when the current node's logic is performed.
         * Pre -> before children
         * In -> in the middle of children
         * Post -> after children*/


        /* The previous code builds a tree that looks like:
            0
          /   \
         1     2
        / \     \
       3   4     5
            \
             6           */

       System.out.println("Calling Pre-Order DFS");
       preOrderDfs(zero);


       System.out.println("Calling In Order DFS");
       inOrderDfs(zero);
        
       System.out.println("Calling Post Order DFS");
       postOrderDfs(zero);
       System.out.println("Notice that for any given node, no values in its right subtree are printed until \nall values in its left subtree are printed, and its own value is not printed until after that.");
                
    }
    
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }    
    
    //Pre-order DFS. Logic is done in the current tree node.
    //preorder handles nodes in the same order that the function calls happen.
    static private void preOrderDfs(Node node) {
        if (node == null) {
            return;
        }
        
        System.out.println(node.val);

        preOrderDfs(node.left);
        preOrderDfs(node.right);
        return;
    }

    //For inorder traversal, we first recursively call the left child, then perform logic.
    //This means no logic will be done until we reach a node without a left child
    //since calling on the left child takes priority over performing logic.
    static private void inOrderDfs(Node node) {
        if (node == null) {
            return;
        }
        

        inOrderDfs(node.left);

        System.out.println(node.val);

        inOrderDfs(node.right);
        return;
    }
    
    //recursively call on the children first and then perform logic on the current node.
    // calling on the children takes priority over performing logic.
    // In a postorder traversal, the root is the last node where logic is done.
    static private void postOrderDfs(Node node) {
        if (node == null) {
            return;
        }

        postOrderDfs(node.left);
        postOrderDfs(node.right);
        System.out.println(node.val);
        return;
    }
}
