package com.prep.Algorithms.dfs.binary.trees;

public class SumOfPathNumbers {

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
			builder.append("TreeNode []");
			return builder.toString();
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode root = null;
		root = add(5, root);
		root = add(3, root);
		root = add(7, root);
		root = add(4, root);
		root = add(6, root);
		root = add(2, root);
		root = add(8, root);
		int res = pathNumberSum(root, 0);
		System.out.println(res);
	}

	private static int pathNumberSum(TreeNode root, int sum) {
		if(root == null)
			return 0;
		
		sum = (10*sum)+root.val;
		
		if(root.left == null && root.right == null)
			return sum;
		
		int x = 0, y = 0;
		if(root.left != null)
			x = pathNumberSum(root.left, sum);
		if(root.right != null)
			y = pathNumberSum(root.right, sum);
		System.out.println(x + " " + y);
		return x + y;

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

}
