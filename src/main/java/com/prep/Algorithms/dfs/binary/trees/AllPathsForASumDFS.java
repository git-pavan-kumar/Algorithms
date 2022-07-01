package com.prep.Algorithms.dfs.binary.trees;

import java.util.ArrayList;
import java.util.List;

public class AllPathsForASumDFS {

	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
		
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append("TreeNode[val=")
			.append(this.val)
			.append("]");
			return s.toString();
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = null;
		root = add(10, root);
		root = add(7, root);
		root = add(11, root);
		root = add(6, root);
		root = add(9, root);
		root = add(13, root);
		root = add(12, root);
		int sum = 26;
		List<List<Integer>> list = getAllSumPaths(root, sum);
		System.out.println(list);
	}

	private static TreeNode add(int i, TreeNode root) {
		if(root == null)
			return new TreeNode(i);
		
		if(i< root.val)
			root.left = add(i, root.left);
		else if(i > root.val)
			root.right = add(i, root.right);
		else
			return root;
		return root;
	}

	private static List<List<Integer>> getAllSumPaths(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> pathArr = new ArrayList<>();
		getAllPaths(root, sum, pathArr, res);
		return res;
	}

	private static void getAllPaths(TreeNode root, int sum, List<Integer> pathArr, List<List<Integer>> res) {
		if(root == null)
			return;
		
		pathArr.add(root.val);
		if(sum == root.val && root.left == null && root.right == null) {
			res.add(new ArrayList<>(pathArr));
			return;
		}
		
		if(null != root.left)
			getAllPaths(root.left, sum-root.val, pathArr, res);
		if(null != root.right)
			getAllPaths(root.right, sum-root.val, pathArr, res);
		
		pathArr.remove(pathArr.size()-1);
	}

}
