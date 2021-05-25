package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n1167 {
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
		ArrayList<Node>[] list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int y = Integer.parseInt(st.nextToken());
				if (y == -1) {
					break;
				}
				int val = Integer.parseInt(st.nextToken());
				list[x].add(new Node(y, val));
				list[y].add(new Node(x, val));
			}
		}
		boolean[] visit = new boolean[n + 1];
		int maxnode = getTree(1, visit, list).n;
		visit = new boolean[n + 1];
		int answer = getTree(maxnode, visit, list).val;
		System.out.println(answer);

	}

	static Node getTree(int start, boolean[] visit, ArrayList<Node>[] list) {
		int n = 0;
		int max = 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(start, 0));
		visit[start] = true;
		while (!q.isEmpty()) {
			Node p = q.poll();
			for (int i = 0; i < list[p.n].size(); i++) {
				Node node = list[p.n].get(i);
				if (!visit[node.n]) {
					int nval = p.val + node.val;
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
