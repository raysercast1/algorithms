import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

//Example code for building graph from an array of edges:
public class Graph {
    static public void main(String[] args) {
        /* First input format: array of edges.
            Each sub-array represents a directed edge in the graph.
            The first element of each sub-array is the source node, and the second element is the destination node.
            For example, [0, 1] represents an edge from node 0 to node 1.*/
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};

         
        /*
         *In an adjacency list, the nodes will be numbered from 0 to n - 1.
         *graph[i] will be a list of all the outgoing (outdegree) edges from the i-th node.

         Index 0: {1} = Node 0 has an edge to Node 1 (represented by {0, 1} in the Directed Edges Array).
         Index 1: {2} = Node 1 has an edge to Node 2 (represented by {1, 2} in the Directed Edges Array).
         Index 2: {0, 3} = Node 2 has edges to Node 0 and Node 3 (represented by {2, 0} and {2, 3} in the Directed Edges Array).
         
         In a nutshell:
         *Each sub-array represents the neighbors of a node in the graph.
         *The index of each sub-array corresponds to a node in the graph.
         *The elements in each sub-array are the nodes that are directly reachable from the node at that index.

         Relationship between the two 2D arrays:
         -The edges array explicitly lists all the edges in the graph.
         -The adjacency list represents the same edges, but organized by node.
         -Each edge in the edges array corresponds to an entry in the adjacency list.
         -For example, the edge {0, 1} in the edges array is represented
           by the entry {1} at index 0 in the adjacency list.
         * */
        int [][] graph = {{1}, {2}, {0, 3}, {}}; //Second input format: adjacency list.
        /*
         * In general
         * The elements in the sub-array at index i represent the nodes that are directly reachable from Node i.
         * Each element j in the sub-array at index i corresponds to an edge [i, j] in the Directed Edges Array.

         This relationship allows us to efficiently traverse the graph and answer questions like:
         -What nodes are directly reachable from Node i?
         -What are the outgoing edges from Node i?

         By using the Adjacency List, we can quickly look up the neighbors of a node, 
         without having to search through the entire Edges Array.
         * */

    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];

            if (!graph.containsKey(x)) { //Check if list of X neighbors exists.
                graph.put(x, new ArrayList<>()); //Create list of neighbors for X.
            }
            graph.get(x).add(y); //Add the neighbor node Y to the list of neighbors of X.

            // if (!graph.containsKey(y)) {
            //     graph.put(y, new ArrayList<>());
            // }
            // graph.get(y).add(x);
            // uncomment the above lines if the graph is undirected
        }
        return graph;
    }
}
