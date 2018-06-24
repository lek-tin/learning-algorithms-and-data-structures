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
Resursive:  
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
Iterative:  
```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        # Initiate the list with 2 roots, one for the left side, one for the right side
        # Using a queue to poll elements
        q = [root, root]
        while len(q) > 0:
            t1 = q.pop(0)
            t2 = q.pop(0)
            if t1 == None and t2 == None:
                continue
            if t1 == None or t2 == None:
                return False
            if t1.val != t2.val:
                return False
            q.append(t1.left)
            q.append(t2.right)
            q.append(t1.right)
            q.append(t2.left)

        return True
```
