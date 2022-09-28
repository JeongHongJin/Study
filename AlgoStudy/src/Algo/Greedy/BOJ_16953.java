package Algo.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		int cnt = 1;
		while (true) {
			if (b <= 0) {
				System.out.println(-1);
				return;
			}
			if (b == a) {
				break;
			}
			if (b % 2 == 0) {
				b /= 2;
			} else {
				if (b % 10 == 1) {
					b /= 10;
				} else {
					System.out.println(-1);
					return;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
