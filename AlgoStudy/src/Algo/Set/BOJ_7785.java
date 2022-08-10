package Algo.Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BOJ_7785 {
	public static void main(String[] args) throws IOException {
		HashSet<String> set = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			if (str[1].equals("enter")) {
				set.add(str[0]);
			} else {
				if (set.contains(str[0]))
					set.remove(str[0]);
			}
		}
		ArrayList<String> list = new ArrayList<>();
		for (String s : set) {
			list.add(s);
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.println(sb);
	}
}
