# maximum path sum between two leaves of a binary tree

```java
// Java program to find maximum path sum between two leaves
// of a binary tree
class Node {
	int val;
	Node left, right;

	Node(int item) {
		val = item;
		left = right = null;
	}
}

// An object of Res is passed around so that the
// same value can be used by multiple recursive calls.
class Res {
	int val;
}

class BinaryTree {
	static Node root;

	// A utility function to find the maximum sum between any
	// two leaves.This function calculates two values:
	// 1) Maximum path sum between two leaves which is stored
	// in res.
	// 2) The maximum root to leaf path sum which is returned.
	int maxPathSumUtil(Node node, Res res) {

		// Base cases
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return node.val;

		// Find maximum sum in left and right subtree. Also
		// find maximum root to leaf sums in left and right
		// subtrees and store them in ls and rs
		int ls = maxPathSumUtil(node.left, res);
		int rs = maxPathSumUtil(node.right, res);

		// If both left and right children exist
		if (node.left != null && node.right != null) {

			// Update result if needed
			res.val = Math.max(res.val, ls + rs + node.val);

			// Return maximum possible value for root being
			// on one side
			return Math.max(ls, rs) + node.val;
		}

		// If any of the two children is empty, return
		// root sum for root being on one side
		return (node.left == null) ? rs + node.val : ls + node.val;
	}

	// The main function which returns sum of the maximum
	// sum path between two leaves. This function mainly
	// uses maxPathSumUtil()
	int maxPathSum() {
		Res res = new Res();
		res.val = Integer.MIN_VALUE;

		int val = maxPathSumUtil(root, res);
	
		if (root.left != null && root.right != null)
			return res.val;
		else {
			//--- for test case ---
			//		 7				 
			//	 / \			 
				// Null -3				 
			// value of res will be INT_MIN but the answer is 4, 
			// which is returned by the function maxPathSumUtil()
			return Math.max(res.val,val);
		}
	}

	//Driver program to test above functions
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(-15);
		tree.root.left = new Node(5);
		tree.root.right = new Node(6);
		tree.root.left.left = new Node(-8);
		tree.root.left.right = new Node(1);
		tree.root.left.left.left = new Node(2);
		tree.root.left.left.right = new Node(6);
		tree.root.right.left = new Node(3);
		tree.root.right.right = new Node(9);
		tree.root.right.right.right = new Node(0);
		tree.root.right.right.right.left = new Node(4);
		tree.root.right.right.right.right = new Node(-1);
		tree.root.right.right.right.right.left = new Node(10);
	
		System.out.println("Max pathSum of the given binary tree is "
				+ tree.maxPathSum());
	}
}
```
