package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n10974 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] out = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		boolean[] visit = new boolean[n];
		permutation(arr, out, visit, 0, n, n);
		System.out.println(sb);
	}

	static void permutation(int[] arr, int[] out, boolean[] visit, int depth, int n, int r) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				out[depth] = arr[i];
				permutation(arr, out, visit, depth + 1, n, r);
				visit[i] = false;
			}
		}
	}

}
