package Leetcode.TreesAndGraphs.Graphs.DFS;

import java.util.Stack;
import java.util.Arrays;

/*
 *DFS on a graph has a time complexity of O(nodes+edges).
  This was because we didn't know how many edges a given node could have.
  However, here we defined that a node can have (at most) 4 edges. Therefore, the work done at each node is O(1),
  and since we are only visiting each node once, the time complexity is equal to the number of nodes, which is O(m ⋅n).
 * */

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] input = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'},
        };

        Solution sol = new Solution();
        int ans = sol.numIslands(input);
        System.out.printf("Ans is: %d for connected components%n", ans);
        System.out.println("[\n [1,1,1,1,0] \n [1,1,0,1,0] \n [1,1,0,0,0] \n [0,0,0,0,0] \n]");
    }

    public static class Solution {
        int m;
        int n;
        boolean[][] seen;

        public int numIslands(char[][] grid) {
           int ans = 0;
           m = grid.length;
           n = grid[0].length;
           seen = new boolean[m][n];

           System.out.println("[\n [1,1,1,1,0] \n [1,1,0,1,0] \n [1,1,0,0,0] \n [0,0,0,0,0] \n]");

           for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == '1' && !seen[row][col]) {
                        ans++;
                        System.out.printf(
                                "Ans updated to %d for main loops -> row: #%d and column #%d%n", ans, row, col);
                        seen[row][col] = true;
                        System.out.println();
                        System.out.printf("Seen in main updated at row #%d and col #%d%n", row, col);
                        System.out.printf("-> %s%n", Arrays.toString(seen[row]));
                        System.out.println();
                        dfs(row, col, grid);
                    }
                }
           }

           return ans;
        }

        public boolean valid(int row, int col, char[][] grid) {
             return 0 <= row && row < m && 0 <= col && col < n && grid[row][col] == '1';
        }
        
        //Coordinates deltas to move in the four directions.
        /*
         * (i, j+1) - right. 
         * (i, j-1) - left.
         * (i+1, j) - below. 
         * (i-1, j) - above.
         * */
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public void dfs(int row, int col, char[][] grid) {
            for (int[] direction: directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    System.out.printf("Seen in dfs updated at row #%d and col #%d%n", nextRow, nextCol);
                    System.out.printf("-> %s%n", Arrays.toString(seen[nextRow]));
                    System.out.println();
                    dfs(nextRow, nextCol, grid);
                }
            }
        }

        public void dfsIte(int startRow, int startCol, char[][] grid) {
            Stack<Integer> rowStack = new Stack<>();
            Stack<Integer> colStack = new Stack<>();
            rowStack.push(startRow);
            colStack.push(startCol);

            while (!rowStack.empty()) {
                int row = rowStack.pop();
                int col = colStack.pop();

                for(int[] direction: directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    
                    //valid = 0 <= row && row < m && 0 <= col && col < n && grid[row][col] == '1';
                    if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                        seen[nextRow][nextCol] = true;
                        rowStack.push(nextRow);
                        colStack.push(nextCol);
                    }
                }
            }
        }
    }
}
