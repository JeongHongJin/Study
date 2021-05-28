package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n10830 {
	static int n;
	static int[][] map;
	static int mod = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) % mod;
			}
		}
		int[][] result = pow(map, b);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	static int[][] pow(int[][] A, long ex) {
		if (ex == 1) {
			return A;
		}
		int[][] ret = pow(A, ex / 2);
		ret = multiply(ret, ret);
		if (ex % 2 == 1) {
			ret = multiply(ret, map);
		}
		return ret;
	}

	static int[][] multiply(int[][] o1, int[][] o2) {
		int[][] ret = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= mod;
				}
			}
		}
		return ret;
	}
}
