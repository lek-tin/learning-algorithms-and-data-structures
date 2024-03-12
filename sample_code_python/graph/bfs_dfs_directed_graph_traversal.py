from collections import defaultdict, deque

class DirectedGraph:
    def __init__(self):
        self.graph = defaultdict(list)

    def add_edge(self, source, destination):
        self.graph[source].append(destination)

    def dfs(self, start):
        visited = set()
        self._dfs_helper(start, visited)

    def _dfs_helper(self, vertex, visited):
        print(vertex, end=" ")
        visited.add(vertex)
        for neighbor in self.graph[vertex]:
            if neighbor not in visited:
                self._dfs_helper(neighbor, visited)

    def bfs(self, start):
        visited = set()
        queue = deque([start])

        while queue:
            current_vertex = queue.popleft()
            if current_vertex not in visited:
                print(current_vertex, end=" ")
                visited.add(current_vertex)
                queue.extend(self.graph[current_vertex])

# Example Usage:
graph = DirectedGraph()

graph.add_edge(0, 1)
graph.add_edge(0, 2)
graph.add_edge(1, 3)
graph.add_edge(2, 4)
graph.add_edge(3, 5)

print("DFS starting from vertex 0:")
graph.dfs(0)

print("\nBFS starting from vertex 0:")
graph.bfs(0)
