package Algo.Set;

import java.util.HashSet;
import java.util.Set;

public class PGR_42895 {
	class Solution {
		public int solution(int N, int number) {
			int answer = -1;
			int num = 0;
			Set<Integer>[] set = new HashSet[9];
			// 8개만 입력 5, 55 , 555, ...
			for (int i = 1; i < 9; i++) {
				num = (num * 10) + N;
				set[i] = new HashSet<>();
				set[i].add(num);
			}
			// 8번 이상 사용하면 -1 return해야함
			for (int i = 1; i < 9; i++) {
				for (int j = 1; j < i; j++) {
					for (int a : set[j]) {
						for (int b : set[i - j]) {
							// i 와 j의 모든 연산 결과값 중복없이 추가
							set[i].add(a + b);
							set[i].add(a - b);
							set[i].add(a * b);
							if (b != 0)
								set[i].add(a / b);
							if (a != 0)
								set[i].add(b / a);
						}
					}
				}
				if (set[i].contains(number)) {
					answer = i;
					return answer;
				}
			}
			return answer;
		}
	}
}
