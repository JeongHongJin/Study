package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//참고 : stranger 블로그

public class n1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cnt = 0;
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] n1, int[] n2) {
				if (n1[1] == n2[1]) {
					return n1[0] - n2[0];
				}
				return n1[1] - n2[1];
			}
		});
		int endtime = 0;
		for (int i = 0; i < n; i++) {
			if (endtime <= arr[i][0]) {
				endtime = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
