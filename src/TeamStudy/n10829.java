package TeamStudy;

import java.math.BigInteger;
import java.util.Scanner;

public class n10829 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger N = sc.nextBigInteger();
		BigInteger a = new BigInteger("0");
		BigInteger r = new BigInteger("2");
		String answer = "";
		while (N.compareTo(a) > 0) {
			answer += N.remainder(r);
			N = N.divide(r);
		}
		StringBuilder sb = new StringBuilder(answer);
		sb.reverse();
		System.out.println(sb);
		sc.close();
	}
}