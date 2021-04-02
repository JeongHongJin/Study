package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class n10989 {
	public static void main(String[] args) throws IOException {
		//buffersedReader를 사용하여 시간 단축 필수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//sort함수를 이용한 오름차순
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb);
	}
}
