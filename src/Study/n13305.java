package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] distance = new long[n - 1];
		long[] price = new long[n];
		for (int i = 0; i < n - 1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		long answer = 0;
		long min = price[0];
		for (int i = 0; i < n - 1; i++) {
			if (min > price[i]) {
				min = price[i];
			}
			answer += (min * distance[i]);
		}
		System.out.println(answer);
	}
}
