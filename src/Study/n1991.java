package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	char data;
	Node left;
	Node right;

	Node(char data) {
		this.data = data;
	}
}

class Tree {
	// 루트 노드 처음엔 null 상태
	Node root;

	public void createNode(char data, char leftData, char rightData) {
		if (root == null) {
			// 아무것도 없는 초기 상태 A루트 노드 생성
			root = new Node(data);
			// 좌우 값이 있는 경우 노드 생성
			if (leftData != '.') {
				root.left = new Node(leftData);
			}
			if (rightData != '.') {
				root.right = new Node(rightData);
			}
		} else {
			// A가 존재하는 경우
			searchNode(root, data, leftData, rightData);
		}
	}

	public void searchNode(Node root, char data, char leftData, char rightData) {
		// 도착한 노드가 null인경우 삽입할 노드가 없는 경우
		if (root == null) {
			return;
		} else if (root.data == data) {
			// 삽입할 노드 위치 찾은경우
			if (leftData != '.') {
				root.left = new Node(leftData);
			}
			if (rightData != '.') {
				root.right = new Node(rightData);
			}
		} else {
			// 아직 찾지 못해서 탐색할 노드가 남아 있는 경우
			searchNode(root.left, data, leftData, rightData);
			searchNode(root.right, data, leftData, rightData);
		}
	}

	// 전위 순회 : 루트 좌 우
	public void preorder(Node root) {
		System.out.print(root.data);
		if (root.left != null)
			preorder(root.left);
		if (root.right != null)
			preorder(root.right);
	}

	// 중위 순회: 좌 루트 우
	public void inorder(Node root) {
		if (root.left != null)
			inorder(root.left);
		System.out.print(root.data);
		if (root.right != null)
			inorder(root.right);
	}

	// 후위 순회: 좌 우 루트
	public void postorder(Node root) {
		if (root.left != null)
			postorder(root.left);
		if (root.right != null)
			postorder(root.right);
		System.out.print(root.data);
	}
}

// 출처 : minhamina 블로그
public class n1991 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Tree tree = new Tree();

		for (int i = 0; i < n; i++) {
			char[] data;
			data = br.readLine().replace(" ", "").toCharArray();
			tree.createNode(data[0], data[1], data[2]);
		}
		tree.preorder(tree.root);
		System.out.println();

		tree.inorder(tree.root);
		System.out.println();

		tree.postorder(tree.root);
	}
}