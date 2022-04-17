package Algo.TwoPointer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PGR_67258 {
	public int[] solution(String[] gems) {
		HashMap<String, Boolean> map = new HashMap<>();
		HashMap<String, Integer> res = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		for (int i = 0; i < gems.length; i++) { // 중복 없이 보석 넣기
			if (!map.containsKey(gems[i])) {
				map.put(gems[i], false);
			}
		}
		int[] answer = new int[2];
		int start = 0; // 시작점
		int end = Integer.MAX_VALUE; // 시작점부터 길이
		for (int i = 0; i < gems.length; i++) {
			q.offer(gems[i]);
			// 보석 갯수 세기
			if (!res.containsKey(gems[i])) {
				res.put(gems[i], 1);
			} else {
				res.put(gems[i], res.get(gems[i]) + 1);
			}

			while (true) {
				String tmp = q.peek();
				if (res.get(tmp) > 1) { // 중복된 보석인경우
					q.poll(); // 기존 있던 보석 삭제
					res.put(tmp, res.get(tmp) - 1); // 보석 한 개 사용
					start++; // 한 칸 뒤의 보석확인
				} else {// 중복 보석 없으면 바로 탈출
					break;
				}
			}
			if (map.size() == res.size() && end > q.size()) {// 모든 보석 다 쓴 경우
				end = q.size();
				break;
			}
		}
		answer[0] = start + 1;
		answer[1] = start + end;
		return answer;
	}
}
