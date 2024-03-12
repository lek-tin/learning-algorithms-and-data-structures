# Print tree level by level

## Use a queue
```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    void printTreeByLevel(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root != null) queue.add(root);
        
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            
            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                for (TreeNode child: node.children) {
                    if (child != null)
                        queue.add(child);
                }
                System.out.println(node.val);
            }
            
            System.out.println("---------------");
        }
    }
    
    // static void helper(TreeNode root, int int level) {
        
    // }
   
    public static class TreeNode {
        public int val;
        public List<TreeNode> children;
        
        public TreeNode(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
        
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            children = new ArrayList<>();
        }
    }
    
    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        
        node_1.children.add(node_2);
        node_1.children.add(node_3);
        node_1.children.add(node_4);
        
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        TreeNode node_7 = new TreeNode(7);
        
        node_2.children.add(node_5);
        node_2.children.add(node_6);
        node_2.children.add(node_7);
        
        TreeNode node_8 = new TreeNode(8);
        TreeNode node_9 = new TreeNode(9);
        TreeNode node_10 = new TreeNode(10);
        
        node_3.children.add(node_8);
        node_3.children.add(node_9);
        node_3.children.add(node_10);
        
        TreeNode node_11 = new TreeNode(11);
        TreeNode node_12 = new TreeNode(12);
        TreeNode node_13 = new TreeNode(13);
        
        node_4.children.add(node_11);
        node_4.children.add(node_12);
        node_4.children.add(node_13);
        
        sol.printTreeByLevel(node_1);
   }
}



// traverse  the tree level by level   

//   1
//  2 3
// 4 5

// 1 2 3 4 5
```
