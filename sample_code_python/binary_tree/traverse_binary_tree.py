class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinaryTreeTraversal:
    def __init__(self):
        self.root = None

    def inorder_traversal(self, node):
        if node:
            # Traverse the left subtree
            self.inorder_traversal(node.left)
            # Visit the current node
            print(node.value, end=" ")
            # Traverse the right subtree
            self.inorder_traversal(node.right)

    def preorder_traversal(self, node):
        if node:
            # Visit the current node
            print(node.value, end=" ")
            # Traverse the left subtree
            self.preorder_traversal(node.left)
            # Traverse the right subtree
            self.preorder_traversal(node.right)

    def postorder_traversal(self, node):
        if node:
            # Traverse the left subtree
            self.postorder_traversal(node.left)
            # Traverse the right subtree
            self.postorder_traversal(node.right)
            # Visit the current node
            print(node.value, end=" ")

# Example usage:
# Create an instance of the BinaryTreeTraversal class
tree_traversal = BinaryTreeTraversal()

# Construct a simple binary tree
tree_traversal.root = TreeNode(1)
tree_traversal.root.left = TreeNode(2)
tree_traversal.root.right = TreeNode(3)
tree_traversal.root.left.left = TreeNode(4)
tree_traversal.root.left.right = TreeNode(5)
tree_traversal.root.right.left = TreeNode(6)
tree_traversal.root.right.right = TreeNode(7)

# In-order traversal
print("In-order traversal:")
tree_traversal.inorder_traversal(tree_traversal.root)
print()

# Pre-order traversal
print("Pre-order traversal:")
tree_traversal.preorder_traversal(tree_traversal.root)
print()

# Post-order traversal
print("Post-order traversal:")
tree_traversal.postorder_traversal(tree_traversal.root)
