package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n3036 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int val = arr[0];
		for (int i = 1; i < n; i++) {
			int gcd = gcd(val, arr[i]);
			sb.append(val / gcd).append('/').append(arr[i] / gcd).append('\n');
		}
		System.out.println(sb);
	}

	static int gcd(int a, int b) {
		int r;
		while (b > 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
