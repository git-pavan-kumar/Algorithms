package com.prep.Algorithms.bfs.binary.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("TreeNode [val=");
			builder.append(val);
			builder.append("]");
			return builder.toString();
		}
		
	}
	public static void main(String[] args) {
		TreeNode root = null;
		root = add(12, root);
		root = add(7, root);
		root = add(1, root);
		root = add(9, root);
		root = add(10, root);
		root = add(5, root);
		TreeNode t = getSuccessor(root, 1);
		System.out.println("Successor : " + t.val);
	}
	private static TreeNode getSuccessor(TreeNode root, int i) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode res = null;
		
		while(!q.isEmpty()) {
			
			TreeNode node = q.poll();
			
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
			
			if(node.val == i)
				break;
		}
		res = q.peek();
		return res;
	}
	
	private static TreeNode add(int val, TreeNode curr) {
		if(curr == null) {
			return new TreeNode(val);
		}
		
		if(val < curr.val)
			curr.left = add(val, curr.left);
		else if(val > curr.val)
			curr.right = add(val, curr.right);
		else
			return curr;
		
		return curr;
	}

}
