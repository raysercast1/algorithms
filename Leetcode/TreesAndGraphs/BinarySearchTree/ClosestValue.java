public class ClosestValue {
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
      }
    

      private static int closestValNode(Node root, double target) {
        if (root == null) return 0;
        int ans = 0;
        int l = 0;
        int r = 0;

        if (root.left == null && root.right == null) {
            ans = root.val;
        }

        if (target < root.val) {
            l = closestValNode(root.left, target);
        }

        if (target > root.val) {
            r = closestValNode(root.right, target);
        }
        
        int closestValue = 

      }
}
