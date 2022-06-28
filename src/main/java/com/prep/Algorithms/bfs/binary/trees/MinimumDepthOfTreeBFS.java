package com.prep.Algorithms.bfs.binary.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfTreeBFS {

	static class TreeNode {
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
		root = add(10, root);
		root = add(8, root);
		root = add(11, root);
		root = add(7, root);
		root = add(5, root);
		int res = traverse(root);
		System.out.println("min depth : " + res);
	}
	private static int traverse(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int ctr = 0;
		
		while(!q.isEmpty()) {
			int len = q.size();
			ctr++;
			for(int i=0; i<len; i++) {
				TreeNode node = q.poll();
				
				if(root == node)
					System.out.printf("%-10d\n", node.val);
				else
					System.out.printf("%-20d", node.val);
				
				
				if(node.left == null && node.right == null)
					return ctr;
				
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
				
			}
		}
		return ctr;
	}
	private static TreeNode add(int i, TreeNode root) {
		if(root == null)
			return new TreeNode(i);
		
		if(i < root.val)
			root.left = add(i, root.left);
		else if(i > root.val)
			root.right = add(i, root.right);
		else
			return root;
		
		return root;
	}

}
