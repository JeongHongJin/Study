package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		for (int i = 0; i < K; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		long left = 1;
		long right = arr[K - 1];
		long middle = 0;
		while (left <= right) {
			long cnt = 0;
			middle = (left + right) / 2;
			for (int i = 0; i < K; i++) {
				cnt += arr[i] / middle;
			}
			if (cnt < N) {
				right = middle - 1;
			} else if (cnt >= N) {
				left = middle + 1;
			}
		}
		System.out.println(right);
	}
}
