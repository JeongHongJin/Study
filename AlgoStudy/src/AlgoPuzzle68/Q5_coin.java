package AlgoPuzzle68;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q5_coin {
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		q.offer(500);
		q.offer(100);
		q.offer(50);
		q.offer(10);
		change(1000, q, 15);
		System.out.println(cnt);
	}

	static void change(int target, Queue<Integer> q, int usable) { // 자바는 큐가 복제되지 않기 때문에 참조를 가져와서 문제를 풀수 없다.
		int coin = q.poll();
		if (q.isEmpty()) {
			if (target / coin <= usable) {
				cnt++;
			}
		} else {
			for (int i = 0; i < (target / coin) + 1; i++) {
				change(target - (coin * i), q, usable - i);
			}
		}
	}

}
