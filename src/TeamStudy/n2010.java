package TeamStudy;

import java.util.Scanner;

public class n2010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 1;
		for (int i = 0; i < N; i++) {
			int plug = sc.nextInt();
			answer += plug;
		}
		answer -= N;
		System.out.println(answer);
		sc.close();
	}
}
