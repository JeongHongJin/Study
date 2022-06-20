package Algo.Number;

public class Codility_Week9_BinaryLen {
	class Solution {
		public int solution(int N) {
			StringBuilder sb = new StringBuilder();
			int max = 0;
			int cnt = 0;
			while (N > 0) {
				sb.insert(0, N % 2);
				N /= 2;
			}
			String s = sb.toString();
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					max = Math.max(max, cnt);
					cnt = 0;
				} else {
					cnt++;
				}
			}
			return max;
		}
	}

}
