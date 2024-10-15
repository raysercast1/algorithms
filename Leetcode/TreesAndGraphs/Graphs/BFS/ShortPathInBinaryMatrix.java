package Leetcode.TreesAndGraphs.Graphs.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
* Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.
* */
public class ShortPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}};
        Solution sol = new Solution();
        int ansOne = sol.shortestPathBinaryMatrix(grid);
        System.out.println("Answer is: " + ansOne);
        System.out.println();

        int[][] gridTwo = {
                {1,0,0},
                {1,1,0},
                {1,1,0}};

        int ansTwo = sol.shortestPathBinaryMatrix(gridTwo);
        System.out.println("Second answer is: " + ansTwo);
    }

    public static class State {
        int row;
        int col;
        int steps;

        State(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public static class Solution {
        int n;
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; //8-directionally. (vertical, horizontal and diagonal).

        /*
        If the queue implementation is efficient, then removing from the left is O(1) which makes the work at each node O(1).
        This means the time complexity is equal to the number of nodes, which is O(n2). The space complexity is also O(n2) as seen can grow to that size.

        >With an efficient queue, BFS has the same time and space complexity as DFS.

        The steps taken to implement BFS are very similar to DFS. At each node, do some logic, then iterate over the neighbors (in this case, the 8 directions),
        check if the neighbor is in seen, and if it isn't, add it to seen and the queue. The main difference is that we are using a queue instead of a stack.
        * */
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[0][0] == 1) {
                return -1;
            }

            n = grid.length;

            // more convenient to use a 2d array instead of a set for seen
            boolean[][] seen = new boolean[n][n];
            seen[0][0] = true;
            Queue<State> queue = new LinkedList<>();
            queue.add(new State(0, 0, 1)); // row, col, steps

            while (!queue.isEmpty()) {
                State state = queue.poll();
                int row = state.row;
                int col = state.col;
                int steps = state.steps;

                if (row == n - 1 && col == n - 1) {
                    return steps;
                }

                for (int[] direction: directions) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                        seen[nextRow][nextCol] = true;
                        queue.add(new State(nextRow, nextCol, steps + 1));
                    }
                }
            }

            return -1;
        }

        public boolean valid(int row, int col, int[][] grid) {
            return 0 <= row && row < n && 0 <= col && col < n && grid[row][col] == 0;
        }
    }
}
