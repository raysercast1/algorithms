package Leetcode.TreesAndGraphs.BreadthFirstSearch;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class LargestValue {
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

        List<Integer> ans = largestVal(eight);
        System.out.printf("Largest nodes in each row are: %s %n",ans.toString());

    }

    private static List<Integer> largestVal(Node root) {
        if (root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currentLength = queue.size();
            int currentMax = Integer.MIN_VALUE;

            for (int i = 0; i < currentLength; i++) {
                Node n = queue.poll();

                assert n != null;
                currentMax = Math.max(currentMax, n.val);
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }

            ans.add(currentMax);
        }

        return ans;
    }
}
