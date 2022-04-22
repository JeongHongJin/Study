package Algo.Implement;

import java.util.ArrayList;

public class PGR_17677 {
	class Solution {
		public int solution(String str1, String str2) {
			int answer = 0;
			str1 = str1.toLowerCase();
			str2 = str2.toLowerCase();
			StringBuilder sb = new StringBuilder();
			ArrayList<String> list1 = new ArrayList<>();
			ArrayList<String> list2 = new ArrayList<>();
			for (int i = 0; i < str1.length(); i++) {
				if (i == str1.length() - 1)
					break;
				if (str1.charAt(i) <= 'z' && str1.charAt(i) >= 'a') {
					if (str1.charAt(i + 1) <= 'z' && str1.charAt(i + 1) >= 'a') {
						sb.append(str1.charAt(i)).append(str1.charAt(i + 1));
						list1.add(sb.toString());
						sb.setLength(0);
					}
				}
			}
			for (int i = 0; i < str2.length(); i++) {
				if (i == str2.length() - 1)
					break;
				if (str2.charAt(i) <= 'z' && str2.charAt(i) >= 'a') {
					if (str2.charAt(i + 1) <= 'z' && str2.charAt(i + 1) >= 'a') {
						sb.append(str2.charAt(i)).append(str2.charAt(i + 1));
						list2.add(sb.toString());
						sb.setLength(0);
					}
				}
			}
			int intersection = 0;
			int union = 0;
			if (list1.size() <= list2.size()) {
				for (int i = 0; i < list1.size(); i++) {
					if (list2.contains(list1.get(i))) {
						intersection++;
						list2.remove(list1.get(i));
					}
				}
				union = list1.size() + list2.size();
			} else {
				for (int i = 0; i < list2.size(); i++) {
					if (list1.contains(list2.get(i))) {
						intersection++;
						list1.remove(list2.get(i));
					}
				}
				union = list1.size() + list2.size();
			}
			if (intersection == 0 && union == 0) {
				return 65536;
			} else {
				return intersection * 65536 / union;
			}
		}
	}
}
