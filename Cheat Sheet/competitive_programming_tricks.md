# Competitive Programming Tricks
Competitive programming often requires efficient and concise code. Here are some useful programming tricks and techniques commonly used in competitive programming:

## Basic

1. **Modulo 1000000007:**
   - Example: Compute (a * b) % 1000000007 to prevent integer overflow.

2. **Fast Input/Output:**
   - Example (Java):
     ```java
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int n = Integer.parseInt(br.readLine().trim());
     ```

3. **Bit Manipulation:**
   - Example: Use XOR to find the unique element in an array.

4. **Prefix Sum and Suffix Sum:**
   - Example: Compute the sum of elements in a range [i, j] using prefix and suffix sums.

5. **Two Pointers Technique:**
   - Example: Find a pair in a sorted array with a given sum using two pointers.

6. **Sliding Window Technique:**
   - Example: Find the maximum sum of a subarray of size k in an array.

7. **Greedy Algorithms:**
   - Example: Solve the activity selection problem.

8. **Binary Search:**
   - Example: Find the square root of a given number using binary search.

9. **Dynamic Programming:**
   - Example: Solve the Fibonacci sequence using dynamic programming.

10. **Fenwick Trees (Binary Indexed Trees):**
    - Example: Update and query prefix sums efficiently using Fenwick Trees.

11. **Priority Queues (Heaps):**
    - Example: Implement Dijkstra's algorithm using a priority queue.

12. **Hashing:**
    - Example: Check if two strings are anagrams using hashing.

13. **Topological Sorting:**
    - Example: Find a topological ordering of vertices in a directed acyclic graph.

14. **Union-Find (Disjoint Set Union):**
    - Example: Implement union-find to detect cycles in an undirected graph.

15. **DFS (Depth-First Search) and BFS (Breadth-First Search):**
    - Example: Traverse a graph using DFS and BFS.

16. **Segment Trees:**
    - Example: Implement a segment tree for range sum queries.

17. **Dijkstra's Algorithm and Floyd-Warshall Algorithm:**
    - Example: Find the shortest path in a weighted graph using Dijkstra's algorithm.

18. **Mo's Algorithm:**
    - Example: Solve range queries on an array efficiently using Mo's algorithm.

19. **Handling Large Input Sizes:**
    - Example: Optimize an algorithm to handle large input sizes in a time-efficient manner.

20. **Avoiding Recalculation:**
    - Example: Memoize Fibonacci numbers to avoid redundant calculations.

## Advanced

Certainly! Let's explore some more advanced programming tricks with concrete examples:

21. **Meet in the Middle:**
    - Example: Given an array, find the number of subsets with a sum less than or equal to a target. Split the array into two halves, generate all possible sums in each half, and combine the results.

22. **Matrix Exponentiation:**
    - Example: Compute the nth Fibonacci number using matrix exponentiation to speed up the process.

23. **Bitmasking:**
    - Example: Solve the traveling salesman problem using bitmasking to represent visited cities.

24. **Ternary Search:**
    - Example: Find the minimum or maximum of a unimodal function using ternary search.

25. **Sparse Table:**
    - Example: Compute range minimum queries (RMQ) in an array using a sparse table.

26. **LCA (Lowest Common Ancestor):**
    - Example: Find the lowest common ancestor in a tree efficiently using binary lifting.

27. **Euler Tour and Euler Path:**
    - Example: Determine if a graph is Eulerian by checking the existence of an Euler tour or path.

28. **KMP Algorithm:**
    - Example: Implement string matching using the Knuth-Morris-Pratt algorithm.

29. **Manhattan Distance:**
    - Example: Solve a problem involving movements in a 2D grid using Manhattan distance.

30. **Cycle Detection:**
    - Example: Detect cycles in an undirected graph using Floyd's cycle-finding algorithm.

31. **Josephus Problem:**
    - Example: Solve the Josephus problem efficiently using mathematical properties.

32. **Chinese Remainder Theorem:**
    - Example: Solve a system of linear congruences using the Chinese Remainder Theorem.

33. **Miller-Rabin Primality Test:**
    - Example: Check if a number is likely prime using the Miller-Rabin primality test.

34. **Geometry Algorithms:**
    - Example: Determine the convex hull of a set of points in the 2D plane.

35. **Centroid Decomposition:**
    - Example: Solve a problem on a tree efficiently using centroid decomposition.

36. **Combinatorics:**
    - Example: Count the number of ways to arrange distinct and identical objects.

37. **Digit DP (Dynamic Programming with Digits):**
    - Example: Solve a problem involving digits using dynamic programming with digits.

38. **Suffix Array and LCP (Longest Common Prefix) Array:**
    - Example: Construct suffix arrays and LCP arrays for efficient string matching.

39. **Dinic's Algorithm:**
    - Example: Solve a maximum flow problem in a network using Dinic's algorithm.

40. **Heavy-Light Decomposition:**
    - Example: Decompose a tree into heavy and light edges for efficient path queries.
