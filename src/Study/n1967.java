package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n1967 {
	static class Node {
		int n, val;

		Node(int n, int val) {
			this.n = n;
			this.val = val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n == 1) {
			System.out.println(0);
			return;
		}
		// 인접 리스트에 node 를 만든다.
		ArrayList<Node>[] list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			// x와y를 연결 시키고 간선의 가중치를 부여한다.
			list[x].add(new Node(y, val));
			list[y].add(new Node(x, val));
		}
		boolean[] visit = new boolean[n + 1];
		// 제일 먼 node를 구한다.
		int maxNode = getTree(1, visit, list).n;
		visit = new boolean[n + 1];
		// 제일 먼 node와의 거리를 구한다.
		int answer = getTree(maxNode, visit, list).val;
		System.out.println(answer);
	}

	// 가중치의 최대 거리와 정점 구하기
	static Node getTree(int start, boolean[] visit, ArrayList<Node>[] list) {
		int max = 0;
		int n = 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(start, 0));
		visit[start] = true;
		while (!q.isEmpty()) {
			// 지금 인접리스트의 위치
			Node position = q.poll();
			for (int i = 0; i < list[position.n].size(); i++) {
				Node node = list[position.n].get(i);
				if (!visit[node.n]) {
					int nval = position.val + node.val;
					q.offer(new Node(node.n, nval));
					if (max < nval) {
						max = nval;
						n = node.n;
					}
					visit[node.n] = true;
				}
			}
		}
		return new Node(n, max);
	}
}
