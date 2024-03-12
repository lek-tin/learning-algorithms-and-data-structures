from collections import defaultdict, deque

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        self.graph[u].append(v)
        self.graph[v].append(u)  # For an undirected graph, add an edge in both directions

    def bfs_traversal(self, start):
        visited = set()
        queue = deque([start])

        while queue:
            current_vertex = queue.popleft()
            if current_vertex not in visited:
                print(current_vertex, end=" ")
                visited.add(current_vertex)
                queue.extend(neighbor for neighbor in self.graph[current_vertex] if neighbor not in visited)

# Example usage:
graph = Graph()
graph.add_edge(0, 1)
graph.add_edge(0, 2)
graph.add_edge(1, 3)
graph.add_edge(2, 4)
graph.add_edge(3, 5)

print("BFS Traversal starting from vertex 0:")
graph.bfs_traversal(0)
