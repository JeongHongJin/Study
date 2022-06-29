package Algo.String;

import java.util.Arrays;
import java.util.Comparator;

public class PGR_17686 {
	class Solution {// 블로그 참고
		public String[] solution(String[] files) {
			String[] answer = new String[files.length];
			Arrays.sort(files, new Comparator<String>() {
				public int compare(String o1, String o2) {
					// head 추출
					String head1 = o1.split("[0-9]")[0];
					String head2 = o2.split("[0-9]")[0];

					// 헤드 비교
					int tmp = head1.toLowerCase().compareTo(head2.toLowerCase());
					// 헤드 동일한 경우 number 비교
					// tail은 비교를 안한다.
					if (tmp == 0) {
						return convertNum(o1, head1) - convertNum(o2, head2);
					} else {
						return tmp;
					}
				}
			});
			return files;
		}

		public int convertNum(String s, String head) {
			s = s.substring(head.length());
			String tmp = "";
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c >= '0' && c <= '9' && tmp.length() < 5) {// 0 ~ 9999
					tmp += c;
				} else {
					break;
				}
			}
			return Integer.parseInt(tmp);
		}
	}
}
