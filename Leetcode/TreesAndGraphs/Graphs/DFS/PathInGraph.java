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
        boolean ansN = solN.validPath(nodes, edgesN, sourceN, destinationN);
        System.out.println("2nd ans: " + ansN);
    }

    public static class Solution {
        Set<String> paths = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        public boolean validPath(int n, int[][] edges, int source, int destination) {
            if (n == 1) return true;
            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int[] edge: edges) {
                int src = edge[0];
                int dest = edge[1];
                
                graph.get(src).add(dest);
                graph.get(dest).add(src);
            }
            
            int ans = dfs(source, destination);

            return ans > 0 ? true : false;
        }

        public int dfs(int node, int dest) {
            int ans = 0;

            for (int neighbor: graph.get(node)) {
                if (!seen.contains(neighbor)) {
                    if (neighbor == dest) {
                        ans++;
                    }
                    seen.add(neighbor);
                    ans += dfs(neighbor, dest);
                }
            }
            
            return ans;
        }
    }
}
