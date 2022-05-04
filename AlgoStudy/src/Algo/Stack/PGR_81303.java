package Algo.Stack;

import java.util.Stack;

public class PGR_81303 {
	class Solution {
		public String solution(int n, int k, String[] cmd) {
			int[] arr = new int[n];
			int size = n;
			int idx = k;
			int cmdlen = cmd.length;
			int num = k;
			Stack<Integer> del = new Stack<>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cmdlen; i++) {
				String[] str = cmd[i].split(" ");
				char c = str[0].charAt(0);
				if (c != 'Z' && c != 'C') {
					num = Integer.parseInt(str[1]);
				}
				if (c == 'D') {
					idx += num;
				} else if (c == 'U') {
					idx -= num;
				} else if (c == 'C') {
					del.push(idx);
					size--;
					if (idx == size)
						idx--;

				} else if (c == 'Z') {
					int tmp = del.pop();
					if (tmp <= idx)
						idx++;
					size++;
				}
			}

			for (int i = 0; i < size; i++) {
				sb.append('O');
			}
			while (!del.isEmpty()) {
				sb.insert(del.pop().intValue(), "X");
			}
			return sb.toString();
		}
	}
}
