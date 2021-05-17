package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 출처: zzang9ha
public class n1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			int[][] arr = new int[m][2];
			int cnt = 1;
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			// 서류 성적 기준으로 오름차순 정렬
			Arrays.sort(arr, new Comparator<int[]>() {
				public int compare(int[] n1, int[] n2) {
					return n1[0] - n2[0];
				}
			});
			// 첫 번째 지원자의 면접 성적 기준
			int pivot = arr[0][1];
			for (int j = 1; j < m; j++) {
				// 면접 성적이 그 전 선발된 지원자보다 높은 경우
				if (arr[j][1] < pivot) {
					// 다음 합격자를 위해 면접 성적 저장
					pivot = arr[j][1];
					cnt++;
				}
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
}