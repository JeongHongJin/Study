package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class n1676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		BigInteger answer = new BigInteger("1");
		BigInteger num = new BigInteger("1");
		BigInteger one = new BigInteger("1");
		while (N > 0) {
			answer = answer.multiply(num);
			num = num.add(one);
			N--;
		}
		String s = answer.toString();
		int cnt = 0;
		boolean flag = false;
		for (int i = s.length() - 1; i > 0; i--) {
			if (s.charAt(i) == '0') {
				cnt++;
				flag = true;
			} else if (s.charAt(i) != '0' && flag) {
				break;
			}
		}
		System.out.println(cnt);
	}
}
