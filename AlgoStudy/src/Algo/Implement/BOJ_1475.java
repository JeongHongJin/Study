package Algo.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1475 {
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int answer = 0;
		for (int i = 0; i < 9; i++) {
			map.put(i, 0);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '6' || c == '9') {
				map.put(6, map.get(6) - 1);
			} else {
				map.put(c - '0', map.get(c - '0') - 1);
			}
		}
		for (int i = 0; i < 9; i++) {
			int tmp = Math.abs(map.get(i));
			if (i == 6) {
				if (tmp % 2 == 0) {
					answer = Math.max(answer, tmp / 2);
				} else {
					answer = Math.max(answer, tmp / 2 + 1);
				}
			} else {
				answer = Math.max(answer, tmp);
			}
		}
		System.out.println(answer);
	}
}
