package Study;

import java.math.BigInteger;
import java.util.Scanner;

public class n1252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n1 = sc.next();
		String n2 = sc.next();
		BigInteger A = new BigInteger(n1, 2);
		BigInteger B = new BigInteger(n2, 2);
		BigInteger cnt = A.add(B);
		A = A.add(B);
		BigInteger r = new BigInteger("0");
		BigInteger binary = new BigInteger("2");
		String answer = "";
		while (A.compareTo(r) > 0) {
			answer += A.remainder(binary);
			A = A.divide(binary);
		}
		StringBuilder sb = new StringBuilder(answer);
		sb.reverse();
		if (cnt.compareTo(r)==0) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}

		sc.close();
	}
}
