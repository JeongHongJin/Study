package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		System.out.println(pow(A, B, C));
	}

	static long pow(long A, long ex, long C) {
		// 지수가 1인경우
		if (ex == 1) {
			return A % C;
		}
		// 지수의 절반에 해당하는 값을 구한다
		long tmp = pow(A, ex / 2, C);
		// 지수가 홀수 인경우 A를 한 번 더 곱해준다
		if (ex % 2 == 1) {
			return (tmp * tmp % C) * A % C;
		}
		return tmp * tmp % C;
	}
}
