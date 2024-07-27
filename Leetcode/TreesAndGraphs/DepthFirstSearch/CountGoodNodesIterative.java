public class CountGoodNodesIterative {
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
          public static void main(String[] args) {
          Node zero = new Node(0);
          Node one = new Node(1);
          Node two = new Node(2);
          Node three = new Node(3);
          Node four = new Node(4);
          Node fourInRight = new Node(4);                                                                                            
          Node five = new Node(5);
          Node six = new Node(6);
          Node seven = new Node(7);
          Node eight = new Node(8);
          Node nine = new Node(9);
          Node ten = new Node(10);
          Node eleven = new Node(11);
          Node twelve = new Node(12);
          Node thirdteen = new Node(13);
   
          five.left = four;
          four.left = eleven;
          eleven.left = seven;
          eleven.right = two;
          five.right = eight;
          eight.left = thirdteen;
          eight.right = fourInRight;
          fourInRight.right = one;
   
          int ans = goodNodes(five, 0);
          System.out.println("Ans is: ");
          System.out.println(ans);
          
      }
        

      private static class Pair {
        Node node;
        itn maxSoFar;

        Pair(Node node, int maxSoFar) {
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
      }

      private static int goodNodes(Node root) {
         Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));
        int ans = 0;

        while (!stack.empty()) {
            Pair pair = stack.pop();
            Node node = pair.node;
            int maxSoFar = pair.maxSoFar;

            if (node.val >= maxSoFar) {
                ans++;
            }
            
            if (node.left != null) {
                stack.push(new Pair(node.left, Math.max(maxSoFar, node.val)));
            }

            if (node.right != null) {
                stack.push(new Pair(node.right, Math.max(maxSoFar, node.val)));
            }

        } 
      }
}
