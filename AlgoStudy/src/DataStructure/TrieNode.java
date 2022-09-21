package DataStructure;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private Map<Character, TrieNode> chilNodes = new HashMap<>();

	private boolean isLastChar;

	Map<Character, TrieNode> getChildNodes() {
		return this.chilNodes;
	}

	boolean isLastChar() {
		return this.isLastChar;
	}

	void setIsLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("go");
		trie.insert("gone");
		trie.insert("guild");
	}
}

class Trie {
	private TrieNode rootNode;

	Trie() {
		rootNode = new TrieNode();
	}

	void insert(String word) {
		TrieNode thisNode = this.rootNode;
		for (int i = 0; i < word.length(); i++) {
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}
		thisNode.setIsLastChar(true);
	}

	boolean contains(String word) {
		TrieNode thisNode = this.rootNode;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = thisNode.getChildNodes().get(c);

			if (node == null) {
				return false;
			}

			thisNode = node;
		}
		return thisNode.isLastChar();
	}
}
