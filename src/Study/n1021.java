package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class n1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			int index = q.indexOf(arr[i]);
			// q의 가운데 index를 찾는다.
			int mid;
			if (q.size() % 2 == 0) {
				mid = q.size() / 2 - 1;
			} else {
				mid = q.size() / 2;
			}
			// 가운데 index보다 작은 경우
			if (index <= mid) {
				// 맨앞의 인덱스를 뒤로 보낸다
				for (int j = 0; j < index; j++) {
					int tmp = q.pollFirst();
					q.offerLast(tmp);
					cnt++;
				}
			} else {
				// 맨뒤의 인덱스를 앞으로 보낸다
				for (int j = 0; j < q.size() - index; j++) {
					int tmp = q.pollLast();
					q.offerFirst(tmp);
					cnt++;
				}
			}
			q.pollFirst();
		}
		System.out.println(cnt);

	}
}
