# Topological Sort

Topological sorting is a linear ordering of the vertices of a directed acyclic graph (DAG) such that for every directed edge (u, v), vertex u comes before v in the ordering. Here's a Java implementation of topological sort using depth-first search (DFS):

```java
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    public static ArrayList<Integer> topologicalSort(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build the adjacency list from prerequisites
        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Perform DFS to find the topological order
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited, stack);
            }
        }

        // Build the result list from the stack
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited, stack);
            }
        }

        // Push the current node to the stack after visiting all neighbors
        stack.push(node);
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        ArrayList<Integer> result = topologicalSort(numCourses, prerequisites);

        System.out.println("Topological Order: " + result);
    }
}
```
