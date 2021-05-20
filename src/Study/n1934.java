package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}
			int y2 = y;
			int x2 = x;
			int r = y % x;
			while (r > 0) {
				y = x;
				x = r;
				r = y % x;
			}
			// gcd = x
			int answer = x2 * y2 / x;
			sb.append(answer).append('\n');
		}
		System.out.println(sb);
	}
}
