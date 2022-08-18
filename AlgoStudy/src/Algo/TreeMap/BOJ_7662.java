package Algo.TreeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_7662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();

			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				if (str[0].charAt(0) == 'I') {
					treeMap.put(Integer.parseInt(str[1]), treeMap.getOrDefault(Integer.parseInt(str[1]), 0) + 1);
				} else {
					if (treeMap.isEmpty()) {
						continue;
					}
					if (str[1].charAt(0) == '1') {
						int max = treeMap.lastKey();
						if (treeMap.get(max) == 1) {
							treeMap.remove(max);
						} else {
							treeMap.put(max, treeMap.get(max) - 1);
						}
					} else {
						int min = treeMap.firstKey();
						if (treeMap.get(min) == 1) {
							treeMap.remove(min);
						} else {
							treeMap.put(min, treeMap.get(min) - 1);
						}
					}
				}
			}
			if (treeMap.isEmpty()) {
				sb.append("EMPTY").append('\n');
			} else {
				sb.append(treeMap.lastKey()).append(' ').append(treeMap.firstKey()).append('\n');
			}
		}
		System.out.println(sb);
	}
}
