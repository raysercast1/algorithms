package Leetcode.TreesAndGraphs.BreadthFirstSearch;

import java.util.Queue;
import java.util.LinkedList;

public class BTreeBFS {
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
        Node one = new Node(1);
        Node three = new Node(3);
        Node four = new Node(4);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node ten = new Node(10);
        Node thirdteen = new Node(13);
        Node fourteen = new Node(14);

        /*
           8
         /   \
        3     10
       / \      \
      1   6     14
         / \   /
        4   7 13
          */        
        eight.left = three;
        eight.right = ten;
        three.left = one;
        three.right = six;
        ten.right = fourteen;
        six.left = four;
        six.right = seven;
        fourteen.right = thirdteen;

        printAllNodes(eight);

    }

    private static void printAllNodes(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();
            //do some logic here for the current level
            

            for (int i = 0; i < nodesInCurrentLevel; i++) {
                Node node = queue.remove();

                //do some logic here for the current node
                System.out.println(node.val);

                //put the next level on top of the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }            
        }
    }
}
