package Algo.SubSet;

import java.util.ArrayList;
import java.util.HashMap;

public class PGR_42890 {
	static int n = 0;
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, String> map = new HashMap<>();
	static ArrayList<String> list = new ArrayList<>();

	public int solution(String[][] relation) {
		int answer = 0;
		n = relation[0].length;
		cnt = 0;
		boolean[] visit = new boolean[n];
		subset(0, visit, relation);
		return cnt;
	}

	static void subset(int depth, boolean[] visit, String[][] relation) {
		if (depth == n) {
			boolean flag = false;
			map = new HashMap<>();
			for (int i = 0; i < relation.length; i++) {
				sb.setLength(0);
				for (int j = 0; j < n; j++) {
					if (!visit[j]) {
						sb.append(relation[i][j]);
					}
				}
				if (sb.length() < 1) {
					return;
				}
				if (map.containsKey(sb.toString())) {
					return;
				} else {
					map.put(sb.toString(), sb.toString());
					flag = true;
				}
			}
			if (flag) {
				String tmp = "";
				for (int i = 0; i < n; i++) {
					if (!visit[i])
						tmp += i;
				}
				for (int i = 0; i < list.size(); i++) {
					String now = list.get(i);
					int tmpcnt = 0;
					for (int j = 0; j < now.length(); j++) {
						if (tmp.contains(Character.toString(now.charAt(j)))) {
							tmpcnt++;
						}
					}
					if (tmpcnt == now.length()) {
						return;
					}
				}
				list.add(tmp);
				cnt++;
			}
			return;
		}
		visit[depth] = true;
		subset(depth + 1, visit, relation);
		visit[depth] = false;
		subset(depth + 1, visit, relation);
	}
}
