package com.prep.Algorithms.bfs.binary.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfTreeBFS {

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
		root = add(7, root);
		root = add(10, root);
		root = add(5, root);
		root = add(3, root);
		root = add(12, root);
		root = add(11, root);
		List<TreeNode> res = getRightViewNodes(root);
		System.out.println(res);
	}

	private static List<TreeNode> getRightViewNodes(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<TreeNode> list = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int len = q.size();
			TreeNode node = null;
			for(int i=0; i<len; i++) {
				node = q.poll();
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
				
			}
			list.add(node);
		}
		
		return list;
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
