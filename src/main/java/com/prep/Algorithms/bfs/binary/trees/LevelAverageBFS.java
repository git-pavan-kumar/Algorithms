package com.prep.Algorithms.bfs.binary.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverageBFS {

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
		root = add(root, 12);
		root = add(root, 7);
		root = add(root, 1);
		root = add(root, 9);
		root = add(root, 2);
		root = add(root, 10);
		root = add(root, 5);
		
		List<Float> res = traverse(root);
		System.out.println(res);
	}

	private static List<Float> traverse(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		List<Float> avg = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int len = q.size();
			float sum = 0;
			for(int i=0; i<len; i++) {
				TreeNode node = q.poll();
				if(node == root)
					System.out.printf("%-10d\n", node.val);
				else
					System.out.printf("%-20d", node.val);
				sum = sum + node.val;
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
			}
			System.out.println();
			avg.add(Float.valueOf(sum/len));
		}
		
		return avg;
	}

	private static TreeNode add(TreeNode curr, int i) {
		if(curr == null) {
			return new TreeNode(i);
		}
		
		if(i < curr.val)
			curr.left = add(curr.left, i);
		else if(i > curr.val)
			curr.right = add(curr.right, i);
		else
			return curr;
		
		return curr;
	}

}
