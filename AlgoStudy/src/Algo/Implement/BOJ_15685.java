package Algo.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_15685 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] map = new int[400][400];
		int answer = 0;
		for (int tc = 0; tc < T; tc++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]) + 200;
			int y = Integer.parseInt(str[1]) + 200;
			int d = Integer.parseInt(str[2]);
			int g = Integer.parseInt(str[3]);
			ArrayList<Integer> dir = new ArrayList<>();
			dir.add(d);
			int nx = x + dx[d];
			int ny = y + dy[d];
			map[x][y] = map[nx][ny] = 1;
			for (int i = 0; i < g; i++) {
				int len = dir.size();
				for (int j = len - 1; j >= 0; j--) {
					int tmp = (dir.get(j) + 1) % 4;
					dir.add(tmp);
					nx += dx[tmp];
					ny += dy[tmp];
					if (nx < 0 || ny < 0 || nx > 400 || ny > 400)
						continue;
					map[nx][ny] = 1;
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					if (i + 1 > 400 || j + 1 > 400) {
						continue;
					}
					if (map[i + 1][j] == 1 && map[i + 1][j + 1] == 1 && map[i][j + 1] == 1) {
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}

}
