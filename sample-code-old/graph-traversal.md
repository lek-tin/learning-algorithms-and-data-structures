# Graph Traversal

## Fundamentals
1. Why every tree is a graph, but not every graph is a tree?
> Similar to the reason why every square is a rectangle, but not every rectangle is a square. It's the definition.  
> A tree is a fully-connected directed graph where every node except the root has exactly one parent. But there are plenty of graphs that don't fit this definition. For example, any graph which contains cycles.  

## Topics
1. n-ary Trees and LCA
2. Graph Cycle
3. Topological Sorting
4. Minimum Spanning Tree
5. BackTracking
6. Shortest Paths
7. Connectivity
8. Disjoint Set
9. Maximum Flow
10. Hard Problems
11. Misc

## Graph Representation
Undirected graph
```java
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}

class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>(n);
 
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
```
## Detect Cycle in a Directed Graph
1. The complexity of detecting a cycle in an undirected graph is `O(n)`.
2. In graph theory, a path that starts from a given vertex and ends at the same vertex is called a cycle.
3. The main difference between graphs and trees is that graphs may contain cycles.

```java
private boolean isCyclic() {
    boolean[] visiting = new boolean[numOfNodes];
    boolean[] visited = new boolean[numOfNodes];

    for (int i = 0; i < numOfNodes; i++) {
        if (detectCycle(graph, i, visiting, visited))
            return true;
    }

    return false;
}

private boolean detectCycle(Map<Integer, List<Integer>> graph, int before, boolean[] visiting, boolean[] visited) {
    if (visiting[before]) return true;

    if (visited[before]) return false;

    visiting[before] = true;

    if (graph.containsKey(before)) {
        for (int after: graph.get(before)) {
            if (detectCycle(graph, after, visiting, visited))
                return true;
        }
    }

    visiting[before] = false;
    visited[before] = true;

    return false;
}
```

## Detect Cycle in an Undirected Graph
Approach 1: dfs using parent node
Notes
1. adjacent nodes need to be added both source and dest nodes, for example, 2 is an adjacent node for 3 and 3 is also one for 2 for the connection 2-3 
```java
import java.util.*;
 
// A class to store a graph edge
 
// A class to represent a graph object
class Graph ... // refer to the Graph Representation section
 
class Main
{
    // Function to perform DFS traversal on the graph on a graph
    public static boolean DFS(Graph graph, int v, boolean[] discovered, int parent)
    {
        // mark the current node as discovered
        discovered[v] = true;
 
        // do for every edge (v, w)
        for (int w: graph.adjList.get(v))
        {
            // if `w` is not discovered
            if (!discovered[w])
            {
                if (DFS(graph, w, discovered, v)) {
                    return true;
                }
            }
 
            // if `w` is discovered, and `w` is not a parent
            else if (w != parent)
            {
                // we found a back-edge (cycle)
                return true;
            }
        }
 
        // No back-edges were found in the graph
        return false;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges, for edges_1, dfs(2, 3, 0) returns true
        List<Edge> edges_1 = Arrays.asList(
            new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 4), new Edge(3, 5)
            new Edge(0, 3)
        );
 
        // total number of nodes in the graph (0 to 11)
        int n = 12;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges, n);
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
 
        // Perform DFS traversal from the first vertex
        if (DFS(graph, 0, discovered, -1)) {
            System.out.println("The graph contains a cycle");
        }
        else {
            System.out.println("The graph doesn't contain any cycle");
        }
    }
}
```

Approach 2: dfs using coloring
```python
from collections import defaultdict 
  
class Graph(): 
    def __init__(self, V): 
        self.V = V 
        self.graph = defaultdict(list) 
  
    def addEdge(self, u, v): 
        self.graph[u].append(v) 
  
    def DFSColor(self, u, color): 
        # GRAY :  This vertex is being processed (DFS 
        #         for this vertex has started, but not 
        #         ended (or this vertex is in function 
        #         call stack) 
        color[u] = "GRAY"
  
        # Get u's adjacent nodes
        for v in self.graph[u]: 
  
            if color[v] == "GRAY": 
                return True
  
            if color[v] == "WHITE" and self.DFSColor(v, color) == True: 
                return True
  
        color[u] = "BLACK"
        return False
  
    def isCyclic(self): 
        # WHITE is the initial state for all nodes
        color = ["WHITE"] * self.V 
  
        for i in range(self.V): 
            if color[i] == "WHITE": 
                if self.DFSColor(i, color) == True: 
                    return True
        return False
```

## Check whether a directed graph is a tree
https://www.baeldung.com/cs/determine-graph-is-tree

1. Find the root of the tree, which is the vertex with no incoming edges. If no node exists, then return false. If more than one node exists, then the graph is not connected, and we should return false as well.
2. Perform a DFS to check that each node has exactly one parent. If not, return false.
3. Make sure that all nodes are visited. If the DFS check didn’t visit all nodes, then return false.
4. Otherwise, the graph is a tree.

## Check whether an undirected graph is a tree
1. Perform a DFS check from any node to make sure that each node has exactly one parent. If not, return false.
2. Check that all nodes are visited. If the DFS check wasn’t able to visit all nodes, then return false.
3. Otherwise, the graph is a tree.
```java
```
