package Algo.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17142 {
	static int n, m;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int answer = Integer.MAX_VALUE;
	static ArrayList<Node> list = new ArrayList<>();

	static class Node {
		int x;
		int y;
		int time;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 2) {
					list.add(new Node(i, j));
				}
			}
		}
		boolean[] visit = new boolean[list.size()];
		comb(0, 0, visit);

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	static void comb(int start, int depth, boolean[] visit) {
		if (depth == m) {
			check(visit);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			comb(i, depth + 1, visit);
			visit[i] = false;
		}
	}

	static void check(boolean[] visit) {
		int[][] tmp = new int[n][n];
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < visit.length; i++) {
			Node now = list.get(i);
			if (!visit[i]) {
				tmp[now.x][now.y] = -1;
			} else {
				q.offer(new Node(now.x, now.y, 0));
			}
		}
		int max = 0;
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (tmp[now.x][now.y] == 2) {
				boolean flag = false;
				loop: for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (tmp[i][j] == 0) {
							flag = true;
							break loop;
						}
					}
				}
				if (!flag) {
					continue;
				}
			}
			max = Math.max(max, now.time);
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (tmp[nx][ny] == 0) {
					tmp[nx][ny] = 1;
					q.offer(new Node(nx, ny, now.time + 1));
				}
				if (tmp[nx][ny] == -1) {
					tmp[nx][ny] = 2;
					q.offer(new Node(nx, ny, now.time + 1));
				}

			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tmp[i][j] == 0) {
					return;
				}
			}
		}
		answer = Math.min(max, answer);
	}
}
