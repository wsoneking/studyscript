package cc.megamind.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalBFS {
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
        bfs (lists, root);
        
        return lists;
    }
    
    public static void bfs(List<List<Integer>> lists, TreeNode root) {
        if(root == null) {
            return;
        }
        List<Integer> list = new LinkedList<Integer>();
        Queue<TreeNode> curr = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        curr.add(root);
        while(!curr.isEmpty()) {
            TreeNode node = curr.poll();
            if(node.left != null) {
                next.add(node.left);
            }
            if(node.right!= null) {
                next.add(node.right);
            }
            list.add(node.val);
            if(curr.isEmpty()) {
                curr = next;
                next = new LinkedList<TreeNode>();
                lists.add(list);
                list = new LinkedList<Integer>();
            }
            
        }
        
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
