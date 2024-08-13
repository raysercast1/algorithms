import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MinAbsDiff {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node() {};

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
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
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
        int ans = minimumAbsoluteDifference(ten);
        System.out.println(String.format("Recursively: The minimun difference btw any of two nodes is: %d", ans));

        int ans2 = minimumAbsDiffIterative(ten);
        System.out.println(String.format("Iterative: The minimun difference btw any of two nodes is: %d", ans));
      }

      private static int minimumAbsoluteDifference(Node root) {
        List<Integer> values = new ArrayList<>();

        dfs(root, values);

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < values.size(); i++) {
            ans = Math.min(ans, Math.abs(values.get(i) - values.get(i - 1)));
        }

        return ans; 
      }
      
      //O(n) time and space complexity.
      //When doing In-order DFS in a BST, we can get the nodes in sorted order w/out the O(n.log n) sort.
      private static void dfs(Node n, List<Integer> values) {
        if (n == null) return;
        
        dfs(n.left, values);
        values.add(n.val);
        dfs(n.left, values);
      }

      private static int minimumAbsDiffIterative(Node root) {
        List<Integer> values = iterativeInorder(root);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            ans = Math.min(ans, Math.abs(values.get(i) - values.get(i - 1)));
        }
        return ans;
      }

     private static List<Integer> iterativeInorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        Node curr = root;
        
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                values.add(curr.val);
                curr = curr.right;
            }
        }

        return values;
     }
}
