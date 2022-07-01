package com.prep.Algorithms.dfs.binary.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CountPathsForSum {

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
		
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			str.append("TreeNode[")
			.append("val = ")
			.append(this.val)
			.append("]");
			return str.toString();
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = null;
		int sum = 15;
		root = add(10, root);
		root = add(7, root);
		root = add(11, root);
		root = add(6, root);
		root = add(9, root);
		root = add(13, root);
		root = add(12, root);
		boolean res = pathsForSum(root, sum, new ArrayList<>());
		System.out.println(res);

	}

	
	private static boolean pathsForSum(TreeNode root, int sum, List<Integer> list) {
		if(root == null)
			return false;
		
		list.add(root.val);
		ListIterator<Integer> itr = list.listIterator();
		int s = 0, cnt = 0;
		while(itr.hasPrevious()) {
			s = s + Integer.valueOf(itr.previous());
			if(s == sum)
				cnt++;
		}
		
		return pathsForSum(root.left, sum - root.val, list) || pathsForSum(root.right, sum - root.val, list);
		
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
