package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long cnt5 = five(n) - five(m) - five(n - m);
		long cnt2 = two(n) - two(m) - two(n - m);
		System.out.println(Math.min(cnt5, cnt2));
	}

	// 5와 2의 갯수를 찾아서 끝자리 0의 갯수를 구한다.
	static long five(long num) {
		int cnt = 0;
		while (num >= 5) {
			cnt += (num / 5);
			num /= 5;
		}
		return cnt;
	}

	static long two(long num) {
		int cnt = 0;
		while (num >= 2) {
			cnt += (num / 2);
			num /= 2;
		}
		return cnt;
	}
}