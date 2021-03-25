package Study;

import java.util.Scanner;

public class n2953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sarr = new int[5];
		int sum;
		int answer = 1;
		for (int i = 0; i < sarr.length; i++) {
			sum = 0;
			for (int j = 0; j < 4; j++) {
				int score = sc.nextInt();
				sum += score;
			}
			sarr[i] = sum;
		}
		int max = sarr[0];
		for (int x = 0; x < sarr.length; x++) {
			if (max < sarr[x]) {
				max = sarr[x];
				answer = x + 1;
			}
		}
		System.out.println(answer + " " + max);
		sc.close();
	}
}