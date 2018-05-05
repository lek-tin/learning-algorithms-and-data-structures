Invert a binary tree.
```
         4
       /   \
      2     7
     / \   / \
    1   3 6   9
```
to
```
         4
       /   \
      7     2
     / \   / \
    9   6 3   1
```

## Thoughts
What if a node is NULL? A NULL has no children, so how to iterate deeper into the tree?
```c++
// Attempt
// class Solution {
// public:
    
     void swapNodes(*leftNode, *rightNode) {
         *temp = *leftNode;
         *leftNode = *rightNode;
         *rightNode = temp;
         return;
     }
    
     TreeNode* invertTree(TreeNode* root) {
         if (root == NULL) 
             return
         invertTree(root->left, )
     }
 };
```
Solution:
```c++
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if(!root || (!root->left && !root->right)) return root;
        invertTree(root->left);
        invertTree(root->right);
        swap(&root->left, &root->right);
        return root;
    }

    void swap(TreeNode** l, TreeNode** r) {
        TreeNode* t = *l;
        *l = *r;
        *r = t;
    }
};
```
