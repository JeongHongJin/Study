package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int max = -1;
		int min = Integer.MAX_VALUE;
		int maxTime = Integer.MAX_VALUE;
		int minTime = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int now = Integer.parseInt(st.nextToken());
				map[i][j] = now;
				if (now > max)
					max = now;
				if (now < min)
					min = now;
			}
		}
		for (int i = max; i >= min; i--) {
			int time = 0;
			int inven = B;
			int norm = i;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (norm == map[x][y]) {
						continue;
					} else if (norm > map[x][y]) {
						int d = norm - map[x][y];
						inven -= d;
						time += d;

					} else {
						int d = map[x][y] - norm;
						inven += d;
						time += d * 2;
					}
				}
			}
			if (inven < 0) {
				continue;
			}
			if (time < maxTime) {
				maxTime = time;
				minTime = norm;
			}
		}
		System.out.println(maxTime + " " + minTime);

	}
}