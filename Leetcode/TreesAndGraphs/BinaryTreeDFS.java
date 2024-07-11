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


       System.out.println("Calling Pre-Order DFS");
       dfs(zero);


       System.out.println("Calling In Order DFS");
       inOrderDfs(zero);

                
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
    static private void dfs(Node node) {
        if (node == null) {
            return;
        }
        
        System.out.println(node.val);

        dfs(node.left);
        dfs(node.right);
        return;
    }

    //For inorder traversal, we first recursively call the left child, then perform logic.
    //This means no logic will be done until we reach a node without a left child
    //since calling on the left child takes priority over performing logic.
    static private void inOrderDfs(Node node) {
        if (node == null) {
            return;
        }
        

        dfs(node.left);

        System.out.println(node.val);

        dfs(node.right);
        return;
    }

}
