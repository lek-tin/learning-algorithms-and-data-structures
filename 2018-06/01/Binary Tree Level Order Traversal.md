Given a binary tree, return the _level order_ traversal of its nodes' values. (ie, from left to right, level by level).

**For example:**
```
Given binary tree `[3,9,20,null,null,15,7]`,
    3
   / \
  9  20
    /  \
   15   7
```
return its level order traversal as:
```
[
  [3],
  [9,20],
  [15,7]
]
```
**Solution:**
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        def sort(root, level):
            if root != None:
                if level == len(res):
                    res.append([])
                res[level].append(root.val)
                sort(root.left, level+1)
                sort(root.right, level+1)
        
        sort(root, 0)
        return res
```
