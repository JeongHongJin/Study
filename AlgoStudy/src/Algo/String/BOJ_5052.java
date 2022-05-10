package Algo.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			String[] str = new String[n];
			boolean flag = true;
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				str[i] = s;
			}
			Arrays.sort(str);
			for (int i = 0; i < n - 1; i++) {
				if (str[i + 1].startsWith(str[i])) {
					flag = false;
					break;
				}
			}
			if (flag)
				answer.append("YES").append('\n');
			else
				answer.append("NO").append('\n');
		}
		System.out.println(answer);

	}
}
