package Leetcode.TreesAndGraphs.Graphs.DFS;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

/*
 The time complexity for DFS on graphs is usually O(n + e),where nn is the number of nodes and ee is the number of edges.
 In the worst-case scenario where every node is connected with every other node, e=nSquare.

 Technically in this problem, the time complexity is O(nSquare) because the input is given as an adjacency matrix, 
 so we always need O(nSquare) to build the hash map. O(e + nSquare) -> O(nSquare).
 In terms of space complexity, the hash map only grows if the edges actually exist. Space complexity O(n + e).
 In the worst case scenario, e=nSquare, but e is still independent of n.
 * */
public class NumberOfProvince {
    //To save the node and its neighbors as list.
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    //To mark each node when it's visited.
    static boolean[] seen;

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {{1,1,0}, {1,1,0}, {0,0,1}};

        int ans = findCircleNum(adjacencyMatrix);

        System.out.printf("Number of provinces (Connected Nodes/Cities) are: %d%n", ans);
    };

    private static int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        //Build the graph
        for (int i = 0; i < n; i++) {
            System.out.printf("Outer loop for node in row: %d%n", i);
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }

            for (int j = i + 1; j < n; j++) {
                System.out.printf("Inner loop for node in col: %d%n", j);
               if (!graph.containsKey(j)) {
                    graph.put(j, new ArrayList<>());
               }
               if (isConnected[i][j] == 1) {
                   graph.get(i).add(j);
                   graph.get(j).add(i);
               } 
            }
        }

       seen = new boolean[n]; 
       for (int i = 0; i < n; i++) {
           System.out.printf("Seen[] = %s%n", Arrays.toString(seen));
           if (!seen[i]) {
               ans++;
               seen[i] = true;
               dfs(i);
           }
       }
      return ans; 
    }

    private static void dfs(int node) {
        System.out.printf("Node seen: %d%n", node);
        for (int neighbor: graph.get(node)) {
            System.out.printf("neighbor: %d%n", neighbor);
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                System.out.printf("Seen in DFS %s%n", Arrays.toString(seen));
                dfs(neighbor);
            }
        }
    }

    private static void dfsIte(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.empty()) {
            int node = stack.pop();
            //List is empty hence the loop will no execute
            for (int neighbor: graph.get(node)) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}
