# DFS


## Traverse a tree
```java
procedure preorder(treeNode v)
{
    visit(v);
    for each child u of v
        preorder(u);
}
```


## Traverse a graph
Similar to traversing a tree, just replace “child” with “neighbor”. But to prevent infinite loops, keep track of the vertices that are already discovered and not revisit them.
```java
procedure dfs(vertex v)
{
    visit(v);
    for each neighbor u of v
        if u is undiscovered
            call dfs(u);
}
```
