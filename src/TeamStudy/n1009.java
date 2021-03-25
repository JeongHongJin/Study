package TeamStudy;

import java.util.Scanner;

public class n1009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] n = new int[4];
		for (int i = 0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = 0; j < 4; j++) {
				n[j] = (int) Math.pow(a, j+1) % 10;
				if(n[j]==0) {
					n[j]=10;
				}
			}
			if (b % 4 == 1) {
				System.out.println(n[0]);
			} else if (b % 4 == 2) {
				System.out.println(n[1]);
			} else if (b % 4 == 3) {
				System.out.println(n[2]);
			} else
				System.out.println(n[3]);
		}
		sc.close();
	}
}
