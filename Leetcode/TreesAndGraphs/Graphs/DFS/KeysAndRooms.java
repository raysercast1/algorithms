import java.util.Set;
import java.util.Stack;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class KeysAndRooms {
    public static void main(String[] args) {
        //Adjacency List as input
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList());

        System.out.println("List of list for Solution one is: " + rooms);
        Solution sol = new Solution();
        boolean ans = sol.canVisitAllRooms(rooms);
        System.out.println(String.format("Answer should be True. ans = %b.", ans));
        System.out.println();

        List<List<Integer>> roomsTwo = Arrays.asList(
                Arrays.asList(1,3),
                Arrays.asList(3,0,1),
                Arrays.asList(2),
                Arrays.asList(0));

        
        Solution sol2 = new Solution();
        System.out.println("List of list for Solution two is: " + roomsTwo);
        boolean ansTwo = sol2.canVisitAllRooms(roomsTwo);

        System.out.println(String.format(
                    "Answer should be False. ans = %b", ansTwo));

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
                System.out.println(String.format("In node #%d looking for neighbor #%d", node, neighbor));
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
                    System.out.println(String.format("In node #%d looking for neighbor #%d", openRoom, keyOfClosedRoom));
                    if (!seen.contains(keyOfClosedRoom)) {
                        seen.add(keyOfClosedRoom);
                        System.out.println("Added neighbor nodes as visited: " + seen.toString());
                        stack.push(keyOfClosedRoom);
                    }
                }
            }
       }
    }
}
