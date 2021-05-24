package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n2470 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] liquid = new long[N];
		long[] answer = new long[2];
		for (int i = 0; i < N; i++) {
			liquid[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(liquid);
		int left = 0;
		int right = N - 1;
		long sum = 0;
		long min = Integer.MAX_VALUE;
		while (left < right) {
			sum = liquid[left] + liquid[right];
			if (min >= Math.abs(sum)) {
				min = Math.abs(sum);
				answer[0] = liquid[left];
				answer[1] = liquid[right];
			}
			min = Math.min(min, Math.abs(sum));
			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		Arrays.sort(answer);
		for (long i : answer) {
			System.out.print(i + " ");
		}
	}
}
