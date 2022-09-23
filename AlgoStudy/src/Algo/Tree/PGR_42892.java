package Algo.Tree;

import java.util.ArrayList;
import java.util.Collections;

public class PGR_42892 {
	class Solution {
		class Node implements Comparable<Node> {
			int x;
			int y;
			int idx;

			Node left;
			Node right;

			Node(int x, int y, int idx) {
				this.x = x;
				this.y = y;
				this.idx = idx;
			}

			public int compareTo(Node n) {
				return n.y - this.y;
			}
		}

		int idx = 0;

		public int[][] solution(int[][] nodeinfo) {
			int[][] answer = new int[2][nodeinfo.length];
			ArrayList<Node> map = new ArrayList<>();
			for (int i = 0; i < nodeinfo.length; i++) {
				map.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
			}
			Collections.sort(map);

			Node root = map.get(0);
			for (int i = 1; i < map.size(); i++) {
				insert(root, map.get(i));
			}
			idx = 0;
			preorder(root, answer[0]);
			idx = 0;
			postorder(root, answer[1]);
			return answer;
		}

		void insert(Node parent, Node child) {
			if (child.x < parent.x) {
				if (parent.left == null) {
					parent.left = child;
				} else {
					insert(parent.left, child);
				}
			} else {
				if (parent.right == null) {
					parent.right = child;
				} else {
					insert(parent.right, child);
				}
			}
		}

		void preorder(Node root, int[] arr) {
			if (root != null) {
				arr[idx++] = root.idx;
				preorder(root.left, arr);
				preorder(root.right, arr);
			}
		}

		void postorder(Node root, int[] arr) {
			if (root != null) {
				postorder(root.left, arr);
				postorder(root.right, arr);
				arr[idx++] = root.idx;
			}
		}
	}
}
