package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1107 {
	static int[] num;
	static int n;
	static int min = Integer.MAX_VALUE;
	static boolean[] broken = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		num = new int[m];
		StringTokenizer st;
		if (m != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int number = Integer.parseInt(st.nextToken());
				broken[number] = true;
			}
		}

		if (n == 100) {
			System.out.println(0);
			return;
		}

		int answer = Math.abs(100 - n);
		min = Math.min(min, answer);

		search(0, "");
		System.out.println(min);
	}

	static void search(int index, String s) {
		for (int i = 0; i < 10; i++) {
			// 고장나지 않은 버튼만 클릭
			if (!broken[i]) {
				// 고장나지 않은 버튼의 수를 추가추가~
				String newS = s + Integer.toString(i);
				// 입력된 숫자가 목표 채널과 차이 + 버튼클릭 횟수 더하기~~
				int num = Math.abs(n - Integer.parseInt(newS)) + newS.length();
				min = Math.min(num, min);
				// 자릿수는 최대 6
				if (index < 6) {
					search(index + 1, newS);
				}
			}
		}
	}
}
