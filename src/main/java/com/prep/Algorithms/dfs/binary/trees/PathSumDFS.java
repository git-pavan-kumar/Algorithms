package com.prep.Algorithms.dfs.binary.trees;

public class PathSumDFS {

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
		int sum = 26;
		root = add(10, root);
		root = add(7, root);
		root = add(11, root);
		root = add(6, root);
		root = add(9, root);
		root = add(13, root);
		root = add(12, root);
		boolean res = pathSum(root, sum);
		System.out.println(res);
	}

	private static boolean pathSum(TreeNode root, int sum) {
		if(null == root)
			return false;
		
		if(root.val == sum && root.left == null && root.right == null)
			return true;
			
		return pathSum(root.left, sum - root.val) || pathSum(root.right, sum - root.val);
		
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
