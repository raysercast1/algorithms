package Leetcode.TreesAndGraphs.BreadthFirstSearch;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

public class ZigZagLevelOrderTraversal {
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
        

       List<List<Integer>> ans = zigzagLevelOrder(one);
       System.out.println("Answer is: ");
       System.out.println(ans);
    }

    private static List<List<Integer>> zigzagLevelOrder(Node root) {
        int depth = 0;
        List<List<Integer>> ans = new LinkedList<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 1));
        List<Integer> inn = new LinkedList<>();

        inn.add(root.val);
        ans.add(inn);

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node n = p.n;
            int d = p.d;

            if (n.left != null) queue.offer(new Pair(n.left, d + 1));
            if (n.right != null) queue.offer(new Pair(n.right, d + 1));

            if (d % 2 != 0) {
                System.out.printf("Odd value is: %d%n", n.val);
                List<Integer> innerList = new LinkedList<>();
                if (n.right != null) {
                    innerList.add(n.right.val);
                }
                if (n.left != null) {
                    innerList.add(n.left.val);
                }
                ans.add(innerList);
            } else {
                System.out.printf("Even value is: %d%n", n.val);
                List<Integer> innerList = new LinkedList<>();
                if (n.left != null) {
                    innerList.add(n.left.val);
                }
                if (n.right != null) {
                    innerList.add(n.right.val);
                }
                ans.add(innerList);
            }
        }
        return ans;
    }

    private static class Pair {
        Node n;
        int d;

        Pair(Node node, int depth) {
            this.n = node;
            this.d = depth;
        }
    }
}
