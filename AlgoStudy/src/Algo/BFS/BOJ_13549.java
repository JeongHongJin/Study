package Algo.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_13549 {
	static class Node {
		int x;
		int dis;

		Node(int x, int dis) {
			this.x = x;
			this.dis = dis;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		boolean[] visit = new boolean[100001];
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(n, 0));
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node now = q.poll();
			visit[now.x] = true;
			if (now.x == k) {
				answer = Math.min(answer, now.dis);
			}
			if (now.x * 2 < visit.length && !visit[now.x * 2]) {
				q.offer(new Node(now.x * 2, now.dis));
			}
			if (now.x + 1 < visit.length && !visit[now.x + 1]) {
				q.offer(new Node(now.x + 1, now.dis + 1));
			}
			if (now.x - 1 >= 0 && !visit[now.x - 1]) {
				q.offer(new Node(now.x - 1, now.dis + 1));
			}
		}
		System.out.println(answer);
	}
}
