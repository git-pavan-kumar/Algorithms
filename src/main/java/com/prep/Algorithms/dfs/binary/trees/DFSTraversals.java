package com.prep.Algorithms.dfs.binary.trees;

public class DFSTraversals {

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
		root = add(10, root);
		root = add(7, root);
		root = add(11, root);
		root = add(9, root);
		root = add(13, root);
		root = add(6, root);
		root = add(12, root);
		traversePreOrder(root);
		System.out.println("");
		traverseInOrder(root);
		System.out.println("");
		traversePostOrder(root);
		System.out.println("");
	}

	private static void traversePostOrder(TreeNode root) {
		if(root == null)
			return;
		traversePostOrder(root.left);
		traversePostOrder(root.right);
		System.out.print(root.val + " --> ");
	}

	private static void traverseInOrder(TreeNode root) {
		if(root == null)
			return;
		traverseInOrder(root.left);
		System.out.print(root.val + " --> ");
		traverseInOrder(root.right);
	}

	private static void traversePreOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val + " --> ");
		traversePreOrder(root.left);
		traversePreOrder(root.right);
	}

	private static TreeNode add(int i, TreeNode root) {
		if(root == null)
			return new TreeNode(i);
		
		if(i < root.val)
			root.left = add(i, root.left);
		else if(i > root.val)
			root.right = add(i, root.right);
		else return root;
		
		return root;
	}

}
