package Algo.Trie;

import java.util.HashMap;

public class PGR_17685 {
	class Solution {
		class Node {
			HashMap<Character, Node> child = new HashMap<>();
			boolean isLast = false;
			int sum = 0;
		}

		class Trie {
			Node root;

			public Trie() {
				root = new Node();
			}

			public void insert(String word) {
				Node thisNode = root;
				for (Character c : word.toCharArray()) {
					if (thisNode.child.get(c) == null) {
						Node node = new Node();
						thisNode.child.put(c, node);
						thisNode = node;
					} else {
						thisNode = thisNode.child.get(c);
					}
				}
				thisNode.isLast = true;
			}
		}

		public int makeSum(Node now) {
			if (now.isLast && now.child.isEmpty())
				return now.sum = 1;
			for (Node node : now.child.values())
				now.sum += makeSum(node);
			if (now.isLast && !now.child.isEmpty())
				now.sum += 1;
			return now.sum;
		}

		public int search(Node now, int cnt) {
			int ret = 0;
			if (now.sum == 1)
				return cnt;
			for (Node node : now.child.values())
				ret += search(node, cnt + 1);
			if (now.isLast)
				ret += cnt;
			return ret;
		}

		public int solution(String[] words) {
			Trie trie = new Trie();
			for (String s : words) {
				trie.insert(s);
			}
			makeSum(trie.root);
			return search(trie.root, 0);
		}
	}
}
