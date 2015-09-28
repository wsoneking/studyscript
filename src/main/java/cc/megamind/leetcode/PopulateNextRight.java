package cc.megamind.leetcode;

import java.util.LinkedList;


public class PopulateNextRight {

	public static void main(String[] args) throws java.lang.Exception {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);

		connect(root);
		System.out.println(root.right.right.next);
	}
	
	public static void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> curr = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> nex = new LinkedList<TreeLinkNode>();
        curr.add(root);
        
        while(!curr.isEmpty()) {
            TreeLinkNode node1 = curr.remove();
            if(!curr.isEmpty()){
                TreeLinkNode node2 = curr.remove();
                node1.next = node2;
                curr.add(0,node2);
            }
            if(node1.left != null) {
                nex.add(node1.left);
                nex.add(node1.right);
            } 
            if(curr.isEmpty()) {
                curr = nex;
                nex = new LinkedList<TreeLinkNode>();
            }
            
        }
        
    }
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) {
			val  = x;
		}
	}
}
