package Algo.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, map[][];
	static boolean[] visit;
	static int[] out = new int[3];
	static ArrayList<Node> place = new ArrayList<>();
	static ArrayList<Node> virus = new ArrayList<>();
	static int answer = 0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					place.add(new Node(i, j));
				}
				if (map[i][j] == 2) {
					virus.add(new Node(i, j));
				}
			}
		}
		visit = new boolean[place.size()];

		comb(0, 0);
		System.out.println(answer);
	}

	static void comb(int start, int depth) {
		if (depth == 3) {
			spread();
			return;
		}
		for (int i = start; i < place.size(); i++) {
			out[depth] = i;
			comb(i + 1, depth + 1);
		}
	}

	static void spread() {
		int[][] tmp = new int[n][m];
		int safe = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < 3; i++) {
			Node now = place.get(out[i]);
			tmp[now.x][now.y] = 1;
		}
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			q.offer(virus.get(i));
		}
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (tmp[nx][ny] == 0) {
					tmp[nx][ny] = 2;
					q.offer(new Node(nx, ny));
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmp[i][j] == 0) {
					safe++;
				}
			}
		}
		answer = Math.max(safe, answer);
	}
}
