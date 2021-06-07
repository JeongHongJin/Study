package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n5014 {
	static class Node implements Comparable<Node> {
		int n, dis;

		Node(int n, int dis) {
			this.n = n;
			this.dis = dis;
		}

		public int compareTo(Node o) {
			return dis - o.dis;
		}
	}

	static int[] move;
	static boolean[] visit;
	static int max, start, goal, up, down;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		max = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());
		move = new int[2];
		visit = new boolean[max + 1];
		move[0] = up;
		move[1] = -down;
		if (start == goal) {
			System.out.println(0);
			return;
		}
		link(start);
		if (answer == 0) {
			System.out.println("use the stairs");
		} else
			System.out.println(answer);
	}

	static int answer = 0;

	static void link(int n) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(n, 0));
		visit[n] = true;
		while (!q.isEmpty()) {
			Node now = q.poll();
			int cnt = now.dis;
			for (int i = 0; i < 2; i++) {
				int nx = now.n + move[i];
				if (nx == goal) {
					answer = cnt + 1;
					return;
				}
				if (nx >= 1 && nx <= max) {
					if (!visit[nx]) {
						visit[nx] = true;
						q.offer(new Node(nx, cnt + 1));
					}
				}
			}
		}
	}
}
