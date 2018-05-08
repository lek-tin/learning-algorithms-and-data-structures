Given a binary tree, return the inorder traversal of its nodes' values.

**Example**:
```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```
**Follow up**: the Recursive solution is trivial, could you do it iteratively?

**Solution**
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        """Check root == None to reduce time on checking"""
        if root == None:
            return []
        stack = []
        result = []
        current = root
        while (current!= None or len(stack) > 0):
            while (current != None):
                stack.append(current)
                current = current.left
            current = stack.pop()
            result.append(current.val)
            current = current.right
        return result
```     
