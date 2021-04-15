package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int r = 1;
		if (N < M) {
			int tmp = N;
			N = M;
			M = tmp;
		}
		int N2 = N;
		int M2 = M;
		// 최대공약수 만들기 r은 N/M의 나머지 N은 다시M M은 다시 r
		while (r > 0) {
			r = N % M;
			N = M;
			M = r;
		}
		int answer = N2 * M2 / N;
		System.out.println(N);
		System.out.println(answer);
	}
}
