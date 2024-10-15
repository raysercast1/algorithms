# Graphs - Breadth First Search - BFS.

Like with trees, in many graph problems, it doesn't really matter if you use DFS or BFS, and there are rarely scenarios where DFS performs better than BFS - people just choose DFS because it's faster/cleaner to implement, especially recursively. Every problem we looked at in the previous example could be solved with a BFS.

But, there are some problems where using BFS is clearly better than using DFS. In trees, this was the case when we were concerned with tree levels. In graphs, it is mostly the case when you are asked to find the shortest path.

Recall that in binary trees, BFS would visit all nodes at a depth d before visiting any node at a depth d + 1. BFS visited the nodes according to their distance from the root.

99% of the time, a graph will not have a tree structure. But even then, the same logic still applies. Imagine whatever node you start from as a "root". Then, the neighbors of the root represent the next level, and the neighbors of those nodes represent the level after that.

BFS on a graph always visits nodes according to their distance from the starting point. This is the key idea behind BFS on graphs - every time you visit a node, you must have reached it in the minimum steps possible from wherever you started your BFS.

>The above statement was always the case on binary trees, even if you did a DFS, because there is only one possible path to any node from the root. In a graph, there could be many paths from a given starting point to any other node. Using BFS will ensure that out of all possible paths, you take the shortest one.

We implemented DFS primarily with recursion, which uses a stack under the hood. To implement BFS, we will use a queue (iteratively) instead.

_See example ShortPathInBinaryMatrix class in BFS folder_.

We can treat the matrix as a graph where each square is a node and all squares have up to 8 edges to adjacent squares (up to, because squares on the edges have less due to potential neighbors being out of bounds). There could be many paths on the matrix, but we want the shortest one. Remember: with traversals, we only want to visit each square at most once, not just for efficiency but also to avoid cycles. If we were to do a DFS, we might not find the shortest path. Take the following example:
![img.png](img.png)

The path marked by the arrows is the optimal path (7 squares), and the red path is a path that might happen if you were to use DFS (11 squares). As you can see, the red path is longer and also "uses" up squares on the optimal path, and thus, this algorithm will not produce a correct answer. To find the shortest path, we should use BFS. With BFS, every time we visit a node, it is guaranteed that we reached it in the fewest steps possible.

Remember when we looked at BFS on trees, and every iteration of the while loop represented a level/depth? Every time the animation above updates is like another "level" on the graph. Each level has the same distance from the start `(0, 0)` if you were to take the optimal path. With trees, we used a for loop inside of a while loop. This was because we cared about the levels as a whole - we wanted to analyze each level separately (find the maximum element, etc.). Here, we don't really care about the levels as a whole - we just want to reach the end `(n - 1, n - 1)`. As such, we don't need the for loop, just the while loop on a queue. We can store the number of steps we have taken with each node, and once we reach the bottom right we know that we have the answer. Recall that this is because the first time we visit a node with BFS, we know we must have reached it with the minimum possible steps.
>Alternatively, you can keep using the format from the binary tree problems.

>Then, you wouldn't need to store the number of steps taken so far with each node. You could initialize a variable `level` before starting the BFS and increment it every time you move up a level (each while loop iteration = one level). When you encounter the target node `(n - 1, n - 1)`, you can return `level`.










