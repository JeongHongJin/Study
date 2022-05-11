package Algo.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		str = br.readLine().split(" ");
		for (int i = 0; i < str.length; i++) {
			int tmp = Integer.parseInt(str[i]);
			if (map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 1);
			}
		}
		str = br.readLine().split(" ");
		for (int i = 0; i < str.length; i++) {
			int tmp = Integer.parseInt(str[i]);
			if (map.containsKey(tmp)) {
				if (map.get(tmp) == 0) {
					map2.put(tmp, map2.get(tmp) + 1);
				} else {
					map.put(tmp, map.get(tmp) - 1);
				}
			} else {
				if (map2.containsKey(tmp)) {
					map2.put(tmp, map2.get(tmp) + 1);
				} else {
					map.put(tmp, 1);
				}
			}
		}
		long answer = 0;
		for (int i : map.values()) {
			answer += i;
		}
		for (int i : map2.values()) {
			answer += i;
		}
		System.out.println(answer);
	}
}
