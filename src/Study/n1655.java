package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class n1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 최소힙과 최대힙을 만든다
		PriorityQueue<Integer> minheap = new PriorityQueue<>((o1, o2) -> {
			return o1 - o2;
		});
		PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> {
			return o2 - o1;
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			// 최소힙과 최대힙크기 같으면 최대힙에 추가
			if (minheap.size() == maxheap.size()) {
				maxheap.offer(num);
			} else {
				minheap.offer(num);
			}
			if (!minheap.isEmpty() && !maxheap.isEmpty()) {
				// 맥스힙의 피크 값이 더 큰 경우
				// 최소힙과 최대힙의 피크 값을 교환한다
				if (minheap.peek() < maxheap.peek()) {
					int tmp = minheap.poll();
					minheap.offer(maxheap.poll());
					maxheap.offer(tmp);
				}
			}
			sb.append(maxheap.peek()).append('\n');
		}
		System.out.println(sb);
	}
}
