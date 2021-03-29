package Study;

import java.util.Scanner;

public class n10988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String answer = "";
		for (int i = s.length() - 1; i >= 0; i--)
			answer += s.charAt(i);
		if (s.equals(answer)) {
			System.out.println(1);
		} else
			System.out.println(0);
		sc.close();
	}
}
