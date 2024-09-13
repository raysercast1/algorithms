import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class PathInGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
        int vertices = 6;
        int source = 0;
        int destination = 5;

        Solution sol = new Solution();
        boolean ans = sol.validPath(vertices, edges, source, destination);

        System.out.println("Ans: " + ans);
        System.out.println();

        int[][] edgesN = {{0,1}, {1,2}, {2,0}};
        int sourceN = 0;
        int destinationN = 2;
        int nodes = 3;

        Solution solN = new Solution();
        boolean ansN = sol.validPath(nodes, edgesN, sourceN, destinationN);
        System.out.println("2nd ans: " + ansN);
    }

    public static class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            boolean ans = false;

            for (int[] edge: edges) {
                int src = edge[0];
                int dest = edge[1];

                if (src == source && dest == destination || src == destination && dest == source) {
                    ans = true;
                }
            }

            return ans;
        }
    }
}
