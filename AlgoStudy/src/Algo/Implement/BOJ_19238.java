package Algo.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_19238 {
	static int n, m, fuel, dis;
	static int[][] map;
	static boolean[][] visit;
	static Node[] destination;
	static Node taxi;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int dis;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Node(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node n) {
			if (this.x == n.x)
				return this.y - n.y;
			return this.x - n.x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		fuel = Integer.parseInt(str[2]);
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1][n + 1];
		destination = new Node[m + 1];
		for (int i = 1; i <= n; i++) {
			str = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(str[j - 1]);
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}
		str = br.readLine().split(" ");
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		taxi = new Node(x, y);
		for (int i = 1; i <= m; i++) {
			str = br.readLine().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int y1 = Integer.parseInt(str[1]);
			int x2 = Integer.parseInt(str[2]);
			int y2 = Integer.parseInt(str[3]);
			map[x1][y1] = i;
			destination[i] = new Node(x2, y2);
		}
		for (int i = 0; i < m; i++) {
			int passenger = find(taxi);
			fuel -= dis;
			if (passenger == -1 || fuel <= 0) {
				System.out.println(-1);
				return;
			}
			int use = dest(taxi, passenger);
			if (fuel < use || use == -1) {
				System.out.println(-1);
				return;
			}
			fuel += use;
			map[taxi.x][taxi.y] = 0;
			taxi = destination[passenger];
		}
		System.out.println(fuel);
	}

	static int find(Node ntaxi) {
		Queue<Node> q = new LinkedList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visit[i], false);
		}
		dis = 0;
		q.offer(ntaxi);
		if (map[ntaxi.x][ntaxi.y] > 0) {
			return map[ntaxi.x][ntaxi.y];
		}
		int size = 0;
		while (!q.isEmpty()) {
			dis++;
			size = q.size();
			for (int i = 0; i < size; i++) {
				Node now = q.poll();
				for (int j = 0; j < 4; j++) {
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];
					if (nx <= 0 || ny <= 0 || nx > n || ny > n)
						continue;
					if (visit[nx][ny])
						continue;
					if (map[nx][ny] >= 0) {
						if (map[nx][ny] > 0)
							pq.offer(new Node(nx, ny));
						q.offer(new Node(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
			if (!pq.isEmpty()) {
				taxi = pq.poll();
				return map[taxi.x][taxi.y];
			}
		}
		return -1;
	}

	static int dest(Node ntaxi, int idx) {
		Queue<Node> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			Arrays.fill(visit[i], false);
		}
		q.offer(ntaxi);
		visit[ntaxi.x][ntaxi.y] = true;
		int size = 0;
		dis = 0;
		while (!q.isEmpty()) {
			size = q.size();
			for (int i = 0; i < size; i++) {
				Node now = q.poll();
				if (now.x == destination[idx].x && now.y == destination[idx].y) {
					return dis;
				}

				for (int j = 0; j < 4; j++) {
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];
					if (nx <= 0 || ny <= 0 || nx > n || ny > n)
						continue;
					if (visit[nx][ny])
						continue;
					if (map[nx][ny] >= 0) {
						q.offer(new Node(nx, ny));
						visit[nx][ny] = true;
					}
				}
			}
			dis++;
		}
		return -1;
	}
}
