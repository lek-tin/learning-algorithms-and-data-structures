Given a binary search tree, write a function `kthSmallest` to find the kth smallest element in it.

**Note:** 
```
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
```
**Example 1:**
```
Input: root = [3,1,4,null,2], k = 1
Output: 1
```
**Example 2:**
````
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
```
**Follow up:**
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

**Solution:**
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.k, self.res = 0, None
        
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        if self.k < k and root.left:
            self.kthSmallest(root.left, k)
        self.k += 1
        if self.k == k:
            self.res = root.val
        if self.k < k and root.right:
            self.kthSmallest(root.right, k)
        return self.res
    def kthSmallest_2(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        sorted = self.inOrder(root)
        return sorted[k-1]
        
    def inOrder(self, root):
        if root is None:
            return  []
        else:
            return self.inOrder(root.left) + [root.val] + self.inOrder(root.right)
 ```
