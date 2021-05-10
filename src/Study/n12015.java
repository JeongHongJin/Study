package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n12015 {
	// LIS방식
	// 시간 복잡도 문제
	// 출처: 팡우송 팽이돌리기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1000000000);
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (list.get(list.size() - 1) < num) {
				list.add(num);
			} else {
				// 이분탐색
				int left = 1;
				int right = list.size() - 1;
				while (left < right) {
					int mid = (left + right) / 2;
					if (list.get(mid) < num) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
				list.set(right, num);
			}
		}
		System.out.println(list.size() - 1);
	}
}