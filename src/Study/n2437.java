package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class n2437 {
	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] output = new int[n];
		boolean[] visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		for (int i = 1; i <= n; i++)
//			perm(n, arr, output, visit, 0, i, 0);
		Collections.sort(list);
		Arrays.sort(arr);
		long sum = 1;
		for (int i = 0; i < n; i++) {
			if (sum < arr[i]) {
				break;
			} else {
				sum += arr[i];
			}
		}
		System.out.println(sum);
	}

//	static void perm(int n, int[] arr, int[] output, boolean[] visit, int depth, int r, int start) {
//		if (depth == r) {
//			long sum = 0;
//			for (int i = 0; i < r; i++) {
//				sum += output[i];
//			}
//			if (!list.contains(sum)) {
//				list.add(sum);
//			}
//			return;
//		}
//		for (int i = start; i < n; i++) {
//			if (!visit[i]) {
//				visit[i] = true;
//				output[depth] = arr[i];
//				perm(n, arr, output, visit, depth + 1, r, i);
//				visit[i] = false;
//			}
//		}
//	}
}
