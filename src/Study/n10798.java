package Study;

import java.util.Scanner;

public class n10798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] S = new String[5];
		String answer = "";
		int max = 0;
		for (int i = 0; i < 5; i++) {
			S[i] = sc.next();
			if (max == 0) {
				max = S[0].length();
			} else if (max < S[i].length()) {
				max = S[i].length();
			}

		}
		for(int i =0;i<5;i++) {
			for(int j=S[i].length();j<max;j++) {
				S[i]+=" ";
			}
		}
		for (int x = 0; x < max; x++) {
			for (int y = 0; y < 5; y++) {
				answer += S[y].charAt(x);
			}
		}
		answer = answer.replace(" ", "");
		System.out.println(answer);
		sc.close();
	}
}
