package com.example.graph;

import java.util.*;

/**
Time Complexity:
The time complexity of BFS is O(V + E), where V is the number of vertices (nodes) and E is the number of edges in the graph.
In the worst case, BFS visits each vertex and each edge exactly once. The while loop runs for every vertex, and for each vertex, it visits its neighbors.
Space Complexity:
The space complexity is O(V), where V is the number of vertices.
The space is used for the queue, visited set, and parentMap. In the worst case, all vertices may be added to the queue, and the visited set may store all vertices. The parentMap stores information for each vertex.
In the context of finding the shortest path from vertex A to vertex B, the space complexity of storing the path is also considered. The constructPath method uses a list to store the path, and in the worst case, this list may contain all vertices on the path.

It's important to note that these complexities are based on the assumption that the graph is represented using an adjacency list. If the graph is represented using an adjacency matrix, the space complexity for the adjacency matrix representation would be O(V^2), which may impact the overall space complexity.
 */
public class ShortestPathBFSUndirected {

    static class Graph {
        private Map<String, List<String>> adjacencyList;

        public Graph() {
            this.adjacencyList = new HashMap<>();
        }

        public void addEdge(String vertex1, String vertex2) {
            adjacencyList.computeIfAbsent(vertex1, k -> new ArrayList<>()).add(vertex2);
            adjacencyList.computeIfAbsent(vertex2, k -> new ArrayList<>()).add(vertex1);
        }

        public List<String> shortestPath(String start, String end) {
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            Map<String, String> parentMap = new HashMap<>();

            queue.add(start);
            visited.add(start);
            parentMap.put(start, null);

            while (!queue.isEmpty()) {
                String currentVertex = queue.poll();

                if (currentVertex.equals(end)) {
                    return constructPath(parentMap, start, end);
                }

                List<String> neighbors = adjacencyList.getOrDefault(currentVertex, Collections.emptyList());
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                        parentMap.put(neighbor, currentVertex);
                    }
                }
            }

            return Collections.emptyList(); // No path found
        }

        private List<String> constructPath(Map<String, String> parentMap, String start, String end) {
            List<String> path = new ArrayList<>();
            String current = end;

            while (current != null) {
                path.add(current);
                current = parentMap.get(current);
            }

            Collections.reverse(path);
            return path;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("D", "E");
        graph.addEdge("C", "F");
        graph.addEdge("F", "G");

        String startVertex = "A";
        String endVertex = "E";

        List<String> shortestPath = graph.shortestPath(startVertex, endVertex);

        if (!shortestPath.isEmpty()) {
            System.out.println("Shortest Path from " + startVertex + " to " + endVertex + ": " + shortestPath);
        } else {
            System.out.println("No path found from " + startVertex + " to " + endVertex);
        }
    }
}

