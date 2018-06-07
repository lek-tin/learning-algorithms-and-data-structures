Given a binary tree, return the postorder traversal of its nodes' values.

**Example:**
```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
```
**Follow up:** Recursive solution is trivial, could you do it iteratively?
**Solution:**   
Recursive👇
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        def traverse(node):
            if node == None:
                return []
            return traverse(node.left)  + traverse(node.right) + [node.val]
        return traverse(root)
```
