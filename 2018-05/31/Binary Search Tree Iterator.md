Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling `next()` will return the next smallest number in the BST.

**Note**: `next()` and `hasNext()` should run in average `O(1)` time and uses `O(h)` memory, where h is the height of the tree.

**Solution:**
```python
# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        self.build(root)
        print(self.stack)

    def build(self, root):
        while root:
            self.stack.append(root)
            root = root.left

    def hasNext(self):
        return len(self.stack) > 0

    def next(self):
        node = self.stack.pop()
        if node.right:
            self.build(node.right)
        return node.val


# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
```
**Explanation:**
left < root < right, if there is no right subtree, the next element is the stack top.
