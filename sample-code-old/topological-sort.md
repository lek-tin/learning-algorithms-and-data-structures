# Topological Sort

Topological sorting is a linear ordering of the vertices of a directed acyclic graph (DAG) such that for every directed edge (u, v), vertex u comes before v in the ordering. Here's a Java implementation of topological sort using depth-first search (DFS):

## DFS with recursion
```java
import java.util.*;

class Node {
    int id;
    List<Node> dependencies;

    public Node(int id) {
        this.id = id;
        this.dependencies = new ArrayList<>();
    }

    public void addDependency(Node dependency) {
        dependencies.add(dependency);
    }
}

public class TopologicalOrder {

    public static List<Node> findTopologicalOrder(List<Node> nodes) {
        List<Node> result = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        Set<Node> visiting = new HashSet<>();

        for (Node node : nodes) {
            if (!visited.contains(node)) {
                if (!dfs(node, visited, visiting, result)) {
                    throw new IllegalArgumentException("Graph contains a cycle");
                }
            }
        }

        // Reverse the result list to get the topological order
        Collections.reverse(result);
        return result;
    }

    private static boolean dfs(Node node, Set<Node> visited, Set<Node> visiting, List<Node> result) {
        visited.add(node);
        visiting.add(node);

        for (Node dependency : node.dependencies) {
            if (!visited.contains(dependency)) {
                if (!dfs(dependency, visited, visiting, result)) {
                    return false; // Cycle detected
                }
            } else if (visiting.contains(dependency)) {
                // Cycle detected
                throw new IllegalArgumentException("Graph contains a cycle");
            }
        }

        visiting.remove(node);
        result.add(node);
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Adding dependencies
        node2.addDependency(node1);
        node3.addDependency(node1);
        node4.addDependency(node2);
        // node1.addDependency(node2); introduces a cycle

        List<Node> nodes = Arrays.asList(node1, node2, node3, node4);

        try {
            List<Node> topologicalOrder = findTopologicalOrder(nodes);

            System.out.println("Topological Order:");
            for (Node node : topologicalOrder) {
                System.out.print(node.id + " ");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

```

## DFS with stack
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

## BFS with in degrees with a Queue
```java
/**
Solution: queue, bfs, topological sort, in-degree, directed graph
Time: O(E+V)
Space: O(E+V)
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for (int[] prereq: prerequisites) {
            int before = prereq[1];
            int after = prereq[0];
            inDegree[after]++;
            graph.putIfAbsent(before, new ArrayList<>());
            graph.get(before).add(after);
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] courses = new int[numCourses];
        int courseCount = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            // Add current course to the order and increment valid course count
            courses[courseCount++] = course;

            if (graph.containsKey(course)) {
                for (int child: graph.get(course)) {
                    inDegree[child]--;
                    // This means all prerequesites for child were met.
                    if (inDegree[child] == 0) {
                        q.offer(child);
                    }
                }
            }
        }

        if (courseCount != numCourses) return new int[]{};

        return courses;
    }
}
```
```

## Problems
- https://leetcode.com/problems/course-schedule
- https://leetcode.com/problems/course-schedule-ii
