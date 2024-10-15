package Leetcode.TreesAndGraphs.Graphs.DFS;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class ConnectedComponents {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};
        Solution sol = new Solution();
        int ans = sol.connectedComponents(n,edges);
        System.out.println("# of connected components: " + ans);
        System.out.println("Expected output: 2 ");
        System.out.println();

        int v = 5;
        int[][] edgesN = {{0,1},{1,2},{2,3},{3,4}};
        Solution solN = new Solution();
        int ansN = solN.connectedComponents(v, edgesN);
        System.out.println("# of connected components: " + ansN);
        System.out.println("Expected output: 1 ");
    }

    public static class Solution {
        int ans = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        public int connectedComponents(int n, int[][] edges) {

            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }
            
            for (int[] edge: edges) {
                int src = edge[0];
                int dst = edge[1];
                graph.get(src).add(dst);
                graph.get(dst).add(src);
            }
            
            for (int i = 0; i < n; i++) {
                if (!seen.contains(i)) {
                    ans++;
                    seen.add(i);
                    dfs(i);
                }
            }
            return ans;
        }

        public void dfs(int n) {
            for (int neighbor: graph.get(n)) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    dfs(neighbor);
                }
            }
        }

    }
}
