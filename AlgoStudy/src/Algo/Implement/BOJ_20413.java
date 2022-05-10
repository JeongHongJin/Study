package Algo.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] val = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			val[i] = Integer.parseInt(s[i]);
		}
		String mvp = br.readLine();
		int num1 = 0;
		int answer = 0;
		for (int i = 0; i < mvp.length(); i++) {
			int tmp = num1;
			if (mvp.charAt(i) == 'S') {
				if (tmp <= val[1]) {
					num1 = val[1] - tmp - 1;
					answer += num1;
				}
			} else if (mvp.charAt(i) == 'G') {
				if (tmp <= val[2]) {
					num1 = val[2] - tmp - 1;
					answer += num1;
				}
			} else if (mvp.charAt(i) == 'P') {
				if (tmp <= val[3]) {
					num1 = val[3] - tmp - 1;
					answer += num1;
				}
			} else if (mvp.charAt(i) == 'D') {
				if (tmp <= val[3]) {
					num1 = val[3];
					answer += num1;
				}
			} else {
				if (tmp <= val[0]) {
					num1 = val[0] - tmp - 1;
					answer += num1;
				}
			}
		}
		System.out.println(answer);
	}
}
