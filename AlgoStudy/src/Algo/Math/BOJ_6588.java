package Algo.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			boolean flag3 = false;
			loop: for (int i = 2; i <= n; i++) {
				int tmp = n - i;
				boolean flag = true;
				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					if (tmp == 0)
						continue;
					boolean flag2 = true;
					for (int j = 2; j * j <= tmp; j++) {
						if (tmp % j == 0) {
							flag2 = false;
							break;
						}
					}
					if (flag2) {
						sb.append(n).append(" = ").append(i).append(" + ").append(tmp).append('\n');
						flag3 = true;
						break loop;
					}
				}
			}
			if (!flag3)
				sb.append("Goldbach's conjecture is wrong.").append('\n');
		}
		System.out.println(sb);
	}
}
