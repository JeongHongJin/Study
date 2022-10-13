package HackerRank.Strings;

import java.util.Arrays;

public class SherlockAndAnagrams {
	public static int sherlockAndAnagrams(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (i == 0 && j == s.length())
					continue;
				String tmp = s.substring(i, j);
				for (int k = i + 1; k <= s.length() - tmp.length(); k++) {
					String tmp2 = s.substring(k, k + tmp.length());
					if (tmp.length() != tmp2.length()) {
						continue;
					}
					char[] c1 = tmp.toCharArray();
					char[] c2 = tmp2.toCharArray();
					Arrays.sort(c1);
					Arrays.sort(c2);
					boolean flag = true;
					for (int x = 0; x < c1.length; x++) {
						if (c1[x] != c2[x]) {
							flag = false;
							break;
						}
					}
					if (flag) {
						answer++;
					}
				}
			}
		}
		return answer;
	}
}
