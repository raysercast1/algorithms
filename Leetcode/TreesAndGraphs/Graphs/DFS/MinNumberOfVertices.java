package Leetcode.TreesAndGraphs.Graphs.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MinNumberOfVertices {
    public static void main(String[] args) {
        /*
         * Notice that vertices 0, 3 and 2 are not reachable from any other node, so we must include them. 
         * Also any of these vertices can reach nodes 1 and 4.
         * */
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(2,1),
                Arrays.asList(3,1),
                Arrays.asList(1,4),
                Arrays.asList(2,4));
        int vertices = 5;

        Solution sol = new Solution();
        List<Integer> ans = sol.findSmallestSetOfVertices(vertices, edges);
        System.out.println("Ans is: " + ans);

        System.out.println();

        /*
         *It's not possible to reach all the nodes from a single vertex. From 0 we can reach [0,1,2,5]. 
         From 3 we can reach [3,4,2,5]. So we output [0,3].
         * */
        List<List<Integer>> edgesTwo = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(0,2),
                Arrays.asList(2,5),
                Arrays.asList(3,4),
                Arrays.asList(4,2));
        int verticesTwo = 6;
        Solution solTwo = new Solution();
        List<Integer> ansTwo = solTwo.findSmallestSetOfVertices(verticesTwo, edgesTwo);
        System.out.println("Ans is: " + ansTwo);

    }

    public static class Solution {
        public List<Integer> findSmallestSetOfVertices(int nodes, List<List<Integer>> edges) {
            int[] indegree = new int[nodes];

            //  idx:0 , idx:1
            //[[Source, Destination]]
            for (List<Integer> edge: edges) {
                System.out.println("Edges: " + edge);
                indegree[edge.get(1)]++; //We only need to count the indegree edge to find all the vertices that indegree == 0.
                System.out.println("Indegree counts of each vertice: " + Arrays.toString(indegree));
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nodes; i++) {
                if (indegree[i] == 0) {
                    ans.add(i); //All unreachable vertices/nodes are the answer because they can only be reachable by themselves.
                }
            }
            return ans; 
        }
    }
}
