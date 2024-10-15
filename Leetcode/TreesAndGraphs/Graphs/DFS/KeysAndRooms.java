package Leetcode.TreesAndGraphs.Graphs.DFS;

import java.util.Set;
import java.util.Stack;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;


/*
 *Adjacency lists are the most convenient input format when the nodes are numbered from 0 to n - 1
  because we don't need to convert it to a hash map - it basically is already in that format.
  As such, the only extra space we use here is in seen set and the recursion call stack, which both are O(n).
  The time complexity is O(n + e) as we visit each node once and the for loops inside each visit
  will iterate up to e times total across the entire algorithm.
 * */
public class KeysAndRooms {
    public static void main(String[] args) {
        //Adjacency List as input
        List<List<Integer>> rooms = Arrays.asList(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of());

        System.out.println("List of list for Solution one is: " + rooms);
        Solution sol = new Solution();
        boolean ans = sol.canVisitAllRooms(rooms);
        System.out.printf("Answer should be True. ans = %b.%n", ans);
        System.out.println();

        List<List<Integer>> roomsTwo = Arrays.asList(
                Arrays.asList(1,3),
                Arrays.asList(3,0,1),
                List.of(2),
                List.of(0));

        
        Solution sol2 = new Solution();
        System.out.println("List of list for Solution two is: " + roomsTwo);
        boolean ansTwo = sol2.canVisitAllRooms(roomsTwo);

        System.out.printf(
                "Answer should be False. ans = %b%n", ansTwo);

    }

    //Since the input is a adjacency list we don't need to create a graph because it's already builded for us.
    public static class Solution {
       Set<Integer> seen = new HashSet<>(); 

       public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int firstRoom = 0;
            seen.add(firstRoom);
            //dfsIte(firstRoom, rooms);
            dfs(firstRoom, rooms); 
            System.out.println("Visited nodes #" + seen.size());
            return seen.size() == rooms.size();
       }

       public void dfs(int node, List<List<Integer>> rooms) {
            for (int neighbor: rooms.get(node)) {
                System.out.printf("In node #%d looking for neighbor #%d%n", node, neighbor);
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    System.out.println("Added neighbor nodes as visited: " + seen.toString());
                    dfs(neighbor, rooms);
                }
            }
       }

       public void dfsIte(int defaultOpenRoom, List<List<Integer>> rooms) {
            Stack<Integer> stack = new Stack<>();
            seen.add(defaultOpenRoom);
            stack.push(defaultOpenRoom);

            while (!stack.empty()) {
                int openRoom = stack.pop();
                for (int keyOfClosedRoom: rooms.get(openRoom)) {
                    System.out.printf("In node #%d looking for neighbor #%d%n", openRoom, keyOfClosedRoom);
                    if (!seen.contains(keyOfClosedRoom)) {
                        seen.add(keyOfClosedRoom);
                        System.out.println("Added neighbor nodes as visited: " + seen);
                        stack.push(keyOfClosedRoom);
                    }
                }
            }
       }
    }
}
