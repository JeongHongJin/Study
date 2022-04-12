package AlgoPuzzle68;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_cutBar {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		System.out.println(cut(1));
	}

	static int cut(int now) {
		if (now >= n) {
			return 0;
		} else if (now < m) { // 막대 자른 경우 막대 개수가 2배된다.
			return 1 + cut(now * 2);
		} else {// 막대의 개수가 m개 이상이라 최대한 자르고 막대가 남는경우
			return 1 + cut(now + m);
		}
	}
}
