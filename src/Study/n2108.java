package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class n2108 {
	public static void mains(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		int cnt = 1;
		int[] cntarr = new int[N];
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				cnt++;
			} else {
				cntarr[i] = cnt;
				cnt = 1;
			}
		}
		int max = cntarr[0];
		for (int i = 0; i < N; i++) {
			if (max <= cntarr[i]) {
				max = cntarr[i];
			}
		}
		int bp = 0;
		for (int i = 0; i < N; i++) {
			if (max == cntarr[i]) {
				if (bp == 1) {
					answer = arr[i];
					break;
				}
				bp++;
			}
		}
		System.out.println(Math.round(sum / N));
		System.out.println(arr[N / 2 + 1]);
		System.out.println(answer);
		System.out.println(N);
	}
}
