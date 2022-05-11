package Algo.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BOJ_14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int answer = 0;
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}
		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			if (map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 1);
			}
		}
		for (String s : list) {
			if (map.containsKey(s)) {
				answer += map.get(s);
			}
		}
		System.out.println(answer);
	}
}
