import java.util.*;

class DirectedGraph {
    private int vertices;
    private Map<Integer, List<Integer>> adjacencyList;

    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public List<Integer> shortestPathBFS(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        queue.offer(start);
        distance.put(start, 0);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!distance.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    distance.put(neighbor, distance.get(currentVertex) + 1);
                    parent.put(neighbor, currentVertex);

                    if (neighbor == end) {
                        return reconstructPath(parent, start, end);
                    }
                }
            }
        }

        // If no path is found
        return Collections.emptyList();
    }

    private List<Integer> reconstructPath(Map<Integer, Integer> parent, int start, int end) {
        List<Integer> path = new ArrayList<>();
        int current = end;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);
        return path;
    }
}

public class ShortestPathBFSDirected {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        int startVertex = 0;
        int endVertex = 5;

        List<Integer> shortestPath = graph.shortestPathBFS(startVertex, endVertex);

        if (!shortestPath.isEmpty()) {
            System.out.println("Shortest path from " + startVertex + " to " + endVertex + ": " + shortestPath);
        } else {
            System.out.println("No path found from " + startVertex + " to " + endVertex);
        }
    }
}
