package Algo.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	static int n, r, c;
	static int sharkSize = 2;
	static int sharkcnt = 0;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node {
		int x;
		int y;
		int dis;

		Node(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int answer = 0;
		StringTokenizer st;
		map = new int[n][n];
		r = 0;
		c = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					r = i;
					c = j;
				}
			}
		}
		while (true) {
			int now = search(r, c);
			if (now == 0)
				break;
			answer += now;
		}
		System.out.println(answer);
	}

	static int search(int x, int y) {
		int time = 0;
		Queue<Node> q = new LinkedList<>();
		ArrayList<Node> fish = new ArrayList<>();
		boolean[][] visit = new boolean[n][n];
		q.offer(new Node(x, y, 0));
		map[x][y] = 0;
		visit[x][y] = true;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (visit[nx][ny])
					continue;
				if (map[nx][ny] < sharkSize && map[nx][ny] > 0) { // 먹을 수 있는 물고기 확인
					q.offer(new Node(nx, ny, now.dis + 1));
					fish.add(new Node(nx, ny, now.dis + 1));
					visit[nx][ny] = true;
				} else if (map[nx][ny] == sharkSize || map[nx][ny] == 0) {
					q.offer(new Node(nx, ny, now.dis + 1));
					visit[nx][ny] = true;
				}
			}
		}
		if (fish.size() == 0) // 먹을 수 있는 물고기 없을때
			return time;
		Node eatfish = fish.get(0);
		for (int i = 1; i < fish.size(); i++) {
			if (fish.get(i).dis < eatfish.dis) { // 물고기 거리 최소로 맞추기
				eatfish = fish.get(i);
			}
			if (fish.get(i).dis == eatfish.dis) {// 같은경우 위에 있는경우
				if (eatfish.x > fish.get(i).x) {
					eatfish = fish.get(i);
				}
			}
		}
		time += eatfish.dis;
		sharkcnt++;
		if (sharkSize == sharkcnt) {
			sharkSize++;
			sharkcnt++;
		}
		r = eatfish.x;
		c = eatfish.y;
		return time;
	}
}
