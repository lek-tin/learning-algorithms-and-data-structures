# Union-Find

## Keep track of component sizes
```java
class Solution {
    
    int[] roots;
    int[] sizes;
    int numOfProvinces;
    
    public int findCircleNum(int[][] isConnected) {
    
        int N = isConnected.length;
        numOfComponents = N;
        roots = new int[N];
        sizes = new int[N];
        
        for (int i = 0; i < N; i++) {
            // every element is itself' root initially
            roots[i] = i;
            sizes[i] = 1;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(isConnected[i][j] == 1) 
                    // if i and j are connected, union the two components
                    union(i, j);
            }
        }
        
        return numOfProvinces;
    }
    
    private int find(int x) {
        int root = x;
        
        while (roots[x] != root) {
            root = roots[root];
        }
        
        // Path compression
        while (x != root) {
            int parent = roots[x];
            roots[x] = root;
            x = parent;
        }
        
        return root;
    }
    
    private void union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        
        // x and y belong to the same component already
        if (root_x == root_y) return;
        
        // merge the smaller component into the bigger one
        if (sizes[x] < sizes[y]) {
            sizes[y] += sizes[x];
            roots[x] = root_y;
        } else {
            sizes[x] += sizes[y];
            roots[y] = root_x;
        }
        
        numOfComponents--;
    }
}
```

## Not keeping track of component sizes

```java
class UnionFind {
  private int size;
  private int[] parents;
    
  public UnionFind(int n) {
    size = n;
    parents = new int[n];

    for (int i = 0; i < n; ++i)
      parents[i] = i;
  }

  public void union(int u, int v) {
    final int pu = find(u);
    final int pv = find(v);
    if (pu == pv)
      return;

    parents[pu] = pv;
    --size;
  }

  public int getSize() {
    return size;
  }

  // With path compression
  private int find(int u) {
    // recursion
//     if (u != parents[u])
//       parents[u] = find(parents[u]);

//     return parents[u];

    // iterative
    int parent = u;

    while(parent != parents[parent]) {
        parent = parents[parent];
    }
        
    while (u != parent) {
        int tempParent = parents[u];
        parents[u] = parent;
        u = tempParent;
    }
      
    return parent;
  }
}
```
