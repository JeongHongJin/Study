package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1072 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		long z = ((100 * y / x));
		int answer = 0;
		if (z >= 99) {
			System.out.println(-1);
			return;
		}
		int left = 1;
		int right = 1000000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			if ((y + mid) * 100 / (x + mid) != z) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}
}
