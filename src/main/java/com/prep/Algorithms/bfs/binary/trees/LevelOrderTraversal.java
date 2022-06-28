package com.prep.Algorithms.bfs.binary.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

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
		TreeNode root = addAll(new int[] {3,2,1,4,5,6}); //O/P: [[1], [2,3], [4,5,6,7]]
		printTreeBFS(root);
		List<List<TreeNode>> res = traverseBFS(root);
		System.out.println(res);
	}

	private static List<List<TreeNode>> traverseBFS(TreeNode root) {
		List<List<TreeNode>> res = new LinkedList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int len = q.size();
			List<TreeNode> list = new ArrayList<>();
			for(int i=0; i<len; i++) {
				TreeNode node = q.poll();
				list.add(node);
				if(node == root)
					System.out.printf("%-30d", node.val);
				else
					System.out.printf("%-10d", node.val);
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
			}
			System.out.println();
			res.add(0, list);
		}
		
		return res;
	}

	private static void printTreeBFS(TreeNode root) {
		// TODO Auto-generated method stub
		
	}

	private static TreeNode addAll(int[] inp) {
		TreeNode root = null;
		for(int i=0; i< inp.length; i++) {
			root = createBinaryTreeBFS(root, inp[i]);
		}
		return root;
	}
	
	private static TreeNode createBinaryTreeBFS(TreeNode curr, int val) {
		if(curr == null) {
			return new TreeNode(val);
		}
		if(val < curr.val)
			curr.left = createBinaryTreeBFS(curr.left, val);
		else if(val > curr.val)
			curr.right = createBinaryTreeBFS(curr.right, val);
		else
			return curr;
		return curr;
	}

}
