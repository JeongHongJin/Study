package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[][] arr = new Integer[n][n];
		for (int i = n - 1; i >= 0; i--) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == null) {
					break;
				} else {
					arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j + 1]);
				}
			}
		}
		System.out.println(arr[n - 1][0]);
	}
}
