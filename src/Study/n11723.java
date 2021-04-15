package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		Boolean[] flag = new Boolean[20];
		Arrays.fill(flag, false);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			while (true) {
				if (s.equals("add")) {
					int n = Integer.parseInt(st.nextToken());
					flag[n - 1] = true;
					break;
				}
				if (s.equals("remove")) {
					int n = Integer.parseInt(st.nextToken());
					flag[n - 1] = false;
					break;
				}
				if (s.equals("check")) {
					int n = Integer.parseInt(st.nextToken());
					if (flag[n - 1])
						sb.append(1).append("\n");
					else
						sb.append(0).append("\n");

					break;
				}
				if (s.equals("toggle")) {
					int n = Integer.parseInt(st.nextToken());
					flag[n - 1] = !flag[n - 1];
					break;
				}
				if (s.equals("all")) {
					Arrays.fill(flag, true);
					break;
				}
				if (s.equals("empty")) {
					Arrays.fill(flag, false);
					break;
				}

			}
		}
		System.out.println(sb);
	}
}
