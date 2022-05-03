package Algo.HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class PGR_92334 {
	class Solution {
		public int[] solution(String[] id_list, String[] report, int k) {
			int[] answer = new int[id_list.length];
			HashMap<String, String> map = new HashMap<>();
			HashMap<String, Integer> ban = new HashMap<>();
			HashSet<String> set = new HashSet<>();
			for (int i = 0; i < report.length; i++) {
				set.add(report[i]);
			}
			for (String s : set) {
				String[] tmp = s.split(" ");
				if (!map.containsKey(tmp[0])) {
					map.put(tmp[0], tmp[1]);
				} else {
					map.put(tmp[0], map.get(tmp[0]) + " " + tmp[1]);
				}
				if (!ban.containsKey(tmp[1])) {
					ban.put(tmp[1], 1);
				} else {
					ban.put(tmp[1], ban.get(tmp[1]) + 1);
				}
			}
			for (int i = 0; i < id_list.length; i++) {
				if (!map.containsKey(id_list[i]))
					continue;
				String[] tmp = map.get(id_list[i]).split(" ");
				for (int j = 0; j < tmp.length; j++) {
					if (ban.get(tmp[j]) > k - 1) {
						answer[i]++;
					}
				}
			}
			return answer;
		}
	}
}
