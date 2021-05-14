package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int answer = Integer.MAX_VALUE;
		while (st.hasMoreTokens()) {
			int sum = 0;
			StringTokenizer num = new StringTokenizer(st.nextToken(), "\\+");
			while (num.hasMoreTokens()) {
				sum += Integer.parseInt(num.nextToken());
			}
			if (answer == Integer.MAX_VALUE) {
				answer = sum;
			} else {
				answer -= sum;
			}
		}
		System.out.println(answer);
	}
}
