package cc.megamind.leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) throws java.lang.Exception {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(10);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(25);
		root.right.left = new TreeNode(30);
		root.right.right = new TreeNode(35);

		System.out.println(levelOrder(root));
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		if (root == null) {
			return null;
		}
		int depth = 0;
		bfs(depth, lists, root);
		return lists;
	}

	public static void bfs(int depth, List<List<Integer>> lists,
			TreeNode root) {
		if (root == null) {
			return;
		}
		if(lists.size() <= depth) {
			List<Integer> list = new LinkedList<Integer>();
			list.add(root.val);
			lists.add(list);
		} else {
			List<Integer> list = lists.get(depth);
			list.add(root.val);
		}
		
		bfs(depth +1, lists, root.left);
		bfs(depth +1, lists, root.right);

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
