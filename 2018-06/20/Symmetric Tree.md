Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:
```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```
But the following `[1,2,2,null,3,null,3]` is not:
```
    1
   / \
  2   2
   \   \
   3    3
```
**Note:**
Bonus points if you could solve it both recursively and iteratively.

**Solution:**
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetricRecursive(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return True
        def isMirror(leftNode, rightNode):
            if leftNode == None and rightNode == None:
                return True
            if leftNode == None or rightNode == None:
                return False
            if leftNode.val != rightNode.val:
                return False
            return (leftNode.val == rightNode.val) and isMirror(leftNode.left, rightNode.right) and isMirror(leftNode.right, rightNode.left)
        return isMirror(root.left, root.right)
```
