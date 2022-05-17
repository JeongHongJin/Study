package Algo.Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SOF_626 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		HashMap<String, int[]> map = new HashMap<>();
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			map.put(s, new int[10]);
			list.add(s);
		}
		for (int i = 0; i < m; i++) {
			String[] str2 = br.readLine().split(" ");
			String s = str2[0];
			int[] tmp = map.get(s);
			int start = Integer.parseInt(str2[1]);
			int end = Integer.parseInt(str2[2]);
			for (int j = start - 9; j < end - 9; j++) {
				tmp[j] = 1;
			}
			map.put(s, tmp.clone());
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			int[] now = map.get(s);
			sb.append("Room ").append(s).append(':').append('\n');
			int cnt = 0;
			int len = 0;
			for (int i = 0; i < now.length; i++) {
				if (now[i] == 0 && len == 0) {
					if (i == now.length - 1)
						continue;
					len++;
					cnt++;
				} else if (now[i] == 0 && len > 0) {
					len++;
				} else if (now[i] == 1 && len > 0) {
					len = 0;
				}
			}
			if (cnt > 0)
				sb.append(cnt).append(" available:").append('\n');
			else
				sb.append("Not available").append('\n');
			len = 0;
			for (int i = 0; i < now.length; i++) {
				if (now[i] == 0 && len == 0) {
					if (i == now.length - 1)
						continue;
					if (i == 0)
						sb.append("09").append('-');
					else
						sb.append(i + 9).append('-');
					len++;
				} else if (now[i] == 0 && len > 0) {
					if (i == now.length - 1)
						sb.append(i + 9).append('\n');
					len++;
				} else if (now[i] == 1 && len > 0) {
					sb.append(i + 9).append('\n');
					len = 0;
				}
			}
			if (s.equals(list.get(list.size() - 1)))
				continue;
			sb.append("-----").append('\n');
		}
		System.out.println(sb);
	}
}
