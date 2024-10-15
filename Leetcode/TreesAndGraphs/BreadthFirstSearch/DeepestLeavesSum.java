package Leetcode.TreesAndGraphs.BreadthFirstSearch;

import java.util.Queue;
import java.util.LinkedList;

public class DeepestLeavesSum {
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
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node ten = new Node(10);

        /*
           1
         /   \
        2     3
       / \      \
      4   5      6
     /            \
    7              8 
          */  

       one.left = two;
       one.right = three;
       two.left = four;
       two.right = five;
       three.right = six;
       four.left = seven;
       six.right = eight;

       int ans = findDeepestLevelBFSAndSumDeepestNodes(ten);
       //int ans = findDeepestLevelBFSAndSumDeepestNodes(one);
       System.out.printf("Ans: %d%n", ans);
    }

  
    private static int findDeepestLevelBFSAndSumDeepestNodes(Node root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        int deepestLevel = 0;
        int ans = 0;
        

        //Finding deepest nodes first.
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            Node n = p.n;
            int depth = p.d;

            if (n.left != null) queue.offer(new Pair(n.left, depth + 1));
            if (n.right != null) queue.offer(new Pair(n.right, depth + 1));

            deepestLevel = Math.max(deepestLevel, depth);
        }
        
        //Traverse to sum the nodes in the deepest level only.
        queue.offer(new Pair(root, 1));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node n = p.n;
            int depth = p.d;
            
            if (deepestLevel == 1) return root.val;

            if (depth == deepestLevel - 1) {
                ans += n.left != null ? n.left.val : 0;
                ans += n.right != null ? n.right.val : 0;
            }
            if (n.left != null) queue.offer(new Pair(n.left, depth + 1));
            if (n.right != null) queue.offer(new Pair(n.right, depth + 1));
        }


        return ans;
    }

    private static class Pair {
        Node n;
        int d; 

        Pair(Node n, int depth) {
            this.n = n;
            this.d = depth;
        }
    }
}
