package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1018 {
	public static boolean[][] flag;
	public static int min = 64;

	public static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int cnt = 0;
		// 첫 번째 칸의 색
		boolean TF = flag[x][y];

		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {
				// 색이 잘못된 경우 cnt++
				if (flag[i][j] != TF) {
					cnt++;
				}
				// 다음칸 색이 바뀌면 true false 반대로
				TF = !TF;
			}
			TF = !TF;
		}
		// 첫 번째 칸 기준으로 색칠 할 갯수(cnt)
		// 첫 번째 칸의 색과 반대되는 색을 기준으로 할(64-cnt) 중 최솟값 cnt
		cnt = Math.min(cnt, 64 - cnt);
		// cnt의 값이 min보다 작아지면 최솟값 갱신
		min = Math.min(min, cnt);
	}

	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		flag = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'W') {
					flag[i][j] = true;
				} else {
					flag[i][j] = false;
				}
			}
		}
		// 체스판 8x8로 자르기
		int N_row = N - 7;
		int M_col = M - 7;
		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {
				find(i, j);
			}
		}
		System.out.println(min);
	}

}
