package Algo.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ_1302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			map.put(s, map.getOrDefault(s, 1) + 1);
			max = Math.max(max, map.get(s));
		}
		ArrayList<String> list = new ArrayList<>();
		for (String s : map.keySet()) {
			if (max == map.get(s)) {
				list.add(s);
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
