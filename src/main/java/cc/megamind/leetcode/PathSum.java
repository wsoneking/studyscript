package cc.megamind.leetcode;

import cc.megamind.leetcode.BinaryTreeLevelOrderTraversal.TreeNode;

public class PathSum {
	public static void main(String[] args) throws java.lang.Exception {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(hasPathSum(root, 11));
	}
	

	public static boolean hasPathSum(TreeNode root, int sum) {

		int value = 0;
		return bfs(root, sum, value);
	}

	public static boolean bfs(TreeNode node, int sum, int value) {
		
		if (node.left == null && node.right == null) {
			if(value + node.val == sum)
				return true;
			else 
				return false;
		}
		if(node.left != null && node.right != null) {
			return bfs(node.left, sum, value + node.val)||bfs(node.right, sum, value + node.val) ? true : false;
		}
		if (node.left == null) {
			return bfs(node.right, sum, value + node.val)? true : false;
		}
		if (node.right == null) {
			return bfs(node.left, sum, value + node.val)? true : false;
		}
		return false;
	}
}
