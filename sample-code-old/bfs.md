# BFS

## Great for problem:
1. shortest path in a graph
2. shortest path in a matrix
3. 

## Hint
1. queue
2. iterate layer by layer
3. queue size
4. visited set/matrix
## Implementation
### With Queue

```java
ReturnType bfs(Node startNode) {
    Queue<Node> queue = new ArrayDeque<>();

    // Distance lookup
    // Also useful for not getting conflicting values because of duplicate nodes
    // Can use HashSet instead of the need is to record connected components
    Map<Node, Integer> distance = new HashMap<>();

    // Important: initialization
    queue.offer(startNode);
    distance.put(startNode, 0); // 1 if it makes more sense given the context

    while (!queue.isEmpty()) {
        Node node = queue.poll();

        // Can add an null node 
        if (node is END) {
            break or return xxx;
        }

        for (Node neighbor: node.getNeighbors()) {
            if (distance.containsKey(neighbor)) {
                continue;
            }

            queue.offer(neighbor);
            distance.put(neighbor, distance.get(node)+1);
        }
    }

    return distance;
    // or
    return distance.keySet();
    // or
    return distance.get(endNode);
}
```

