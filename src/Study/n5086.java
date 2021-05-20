package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n5086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x == 0 && y == 0) {
				System.out.println(sb);
				return;
			}
			if (y % x == 0) {
				sb.append("factor").append('\n');
			} else if (x % y == 0) {
				sb.append("multiple").append('\n');
			} else {
				sb.append("neither").append('\n');
			}
		}
	}
}
