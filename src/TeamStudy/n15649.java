package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		int[] out = new int[n];
		boolean[] visit = new boolean[n];
		perm(arr, out, visit, 0, n, m);
		System.out.println(sb);

	}

	static StringBuilder sb = new StringBuilder();

	static void perm(int[] arr, int[] out, boolean[] visit, int depth, int n, int r) {

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
				perm(arr, out, visit, depth + 1, n, r);
				visit[i] = false;
			}

		}
	}
}
