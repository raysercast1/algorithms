package Leetcode.TreesAndGraphs.Graphs.DFS;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] connectedIsland = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        Solution sol = new Solution();
        int ans = sol.maxAreaOfIsland(connectedIsland);
        System.out.println("Number of connected island: " + ans);
        System.out.println("Expected ans is 6");
    }



    public static class Solution {
        int colLength;
        int rowLength;
        boolean[][] seen;

        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            rowLength = grid.length;
            colLength = grid[0].length;
            seen = new boolean[rowLength][colLength];
            
            for(int row = 0; row < rowLength; row++) {
                for (int col = 0; col < colLength; col++) {
                    if (grid[row][col] == 1 && !seen[row][col]) {
                        ans++;
                        seen[row][col] = true;
                        dfs(row, col, grid);
                    }
                }
            }

            return ans;   

        }

        int[][] coordinates = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public boolean validMove(int row, int col, int[][] grid) {
            return 0 <= col && col < colLength && 0 <= row && row < rowLength && grid[row][col] == 1;
        }

        public void dfs(int row, int col, int[][] grid) {
            for (int[] direction: coordinates) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if (validMove(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    dfs(nextRow, nextCol, grid);
                }
            }
        }
    }
}
