package Leetcode.TreesAndGraphs.Graphs.DFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class AllPathsLeadToCityZero {
    public static void main(String[] args) {
        //How many routes do we need to swap the direction in order to make all cities pointing to City Zero?
        Solution sol = new Solution();
        int[][] directedEdgesGraph = {{0,1}, {3,1}, {2,3}, {4,0}, {5,4}};
        int cities = 10;   

        System.out.println("Directed Edges Graph: [ \n [0,1] \n [3,1] \n [2,3] \n [4,0] \n [5,4] \n]");
        int ans = sol.minReorder(cities, directedEdgesGraph);
        System.out.printf("Number of swapped routes to point all to City Zero: #%d%n", ans);
    }

    //The time and space complexity of this algorithm is O(n) because we only visit each node once, 
    //do constant work, and the number of edges is n−1 = O(n). Roads, Graph, and Visited all take up at most O(n) space.
    public static class Solution {
        Set<String> roads = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        
        public int minReorder(int cities, int[][] connections) {
            for (int city = 0; city < cities; city++) {
                graph.put(city, new ArrayList<>());
            }

            for (int[] connection: connections) {
                int source = connection[0];
                int destination = connection[1];

                //Changing from directed nodes to undirected nodes
                graph.get(source).add(destination);
                graph.get(destination).add(source);
                
                //saving original directed node in hashSet to do validation in O(1)
                roads.add(convertToHash(source, destination));
            }

            //In an undirected graphs starting from City Zero using DFS we'll traverse from City #0 which is the starting point.
            //We start from City #0 so every movement in the traversal will be again from it. (Away from City Zero).
            visited.add(0);
            return dfsIte(0);
        }
        
        public int dfs(int node) {
            int ans = 0;

            for (int neighbor: graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    //If direction of 'undirected graph'(The graph we build) is equal to 
                    //direction of 'directed graph' (The original graph) then swap routes 
                    //because we need to go TOWARD City Zero NOT away from it.
                    if (roads.contains(convertToHash(node, neighbor))) {
                        //swap direction of cities route
                        ans++;
                    }

                    visited.add(neighbor);
                    ans += dfs(neighbor);
                }
            }
            return ans;
        }

        public String convertToHash(int fromCityX, int toCityY) {
            return fromCityX + "," + toCityY;
        }

        public int dfsIte(int cityZero) {
            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(cityZero);

            while (!stack.empty()) {
                int node = stack.pop();
                for (int neighbor: graph.get(cityZero)) {
                    if (!visited.contains(neighbor)) {
                        if (roads.contains(convertToHash(node, neighbor))) {
                            ans++;
                        }
                        visited.add(neighbor);
                        stack.push(neighbor);
                    }
                }
            }
            return ans;
        } 
    }
}
