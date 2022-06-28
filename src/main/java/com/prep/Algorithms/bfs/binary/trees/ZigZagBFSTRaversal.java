package com.prep.Algorithms.bfs.binary.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagBFSTRaversal {

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
		root = addAll(root, 3);
		root = addAll(root, 4);
		root = addAll(root, 1);
		List<List<TreeNode>> res = traverse(root);
		System.out.println(res);
	}

	private static TreeNode addAll(TreeNode root, int i) {
		if(root == null) {
			return new TreeNode(i);
		}
		
		if(i < root.val)
			root.left = addAll(root.left, i);
		else if(i > root.val)
			root.right = addAll(root.right, i);
		else
			return root;
		
		return root;
	}

	private static List<List<TreeNode>> traverse(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<List<TreeNode>> res = new ArrayList<>();
		boolean rightToLeft = false;
		q.add(root);
		while(!q.isEmpty()) {
			int len = q.size();
			List<TreeNode> list = new LinkedList<>();
			for(int i=0; i<len; i++) {
				TreeNode node = q.poll();
				System.out.print(node.val);
				
				if(rightToLeft)
					list.add(0, node);
				else
					list.add(node);
				
				if(node.left != null)
					q.add(node.left);
				if(node.right != null) 
					q.add(node.right);
			}
			res.add(list);
			rightToLeft = !rightToLeft;
		}
		
		return res;
	}

}
