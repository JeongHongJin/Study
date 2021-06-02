package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n10610 {
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[10];
		int num;
		int sum = 0;
		// 각 자리의 숫자 저장
		for (int i = 0; i < s.length(); i++) {
			num = s.charAt(i) - '0';
			sum += num;
			arr[num]++;
		}
		// 0의 갯수가 없거나 3의 배수가 아니면
		if (arr[0] == 0 || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		StringBuilder sb = new StringBuilder();
		// 9부터 0까지의 갯수를 모두 출력
		for (int i = 9; i >= 0; i--) {
			while (arr[i] > 0) {
				arr[i]--;
				sb.append(i);
			}
		}
		System.out.println(sb);
	}
}
