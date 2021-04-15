package TeamStudy;

import java.util.Scanner;

public class n15829 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		long M = 1234567891;
		sc.nextLine();
		String s = sc.next();
		long answer = 0;
		for (int i = 0; i < L; i++) {
			long x = (s.charAt(i) - 96);
			for (int j = 0; j < i; j++) {
				x *= 31;
				x %= M;
			}
			answer += x;
			answer %= M;
		}
		System.out.println(answer);
		sc.close();
	}
}