package Algo.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		HashMap<String, String> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			map.put(s, Integer.toString(i));
			map.put(Integer.toString(i), s);
		}
		for (int i = 0; i < m; i++) {
			sb.append(map.get(br.readLine())).append('\n');
		}
		System.out.println(sb);
	}
}
