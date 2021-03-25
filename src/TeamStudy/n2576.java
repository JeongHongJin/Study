package TeamStudy;

import java.util.Arrays;
import java.util.Scanner;

public class n2576 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] n = new int[7];
		int sum = 0;
		int min = 0;
		for (int i = 0; i < n.length; i++) {
			n[i] = sc.nextInt();
			if (n[i] % 2 == 1)
				sum += n[i];
		}
		Arrays.sort(n);
		for (int j = 0; j < n.length; j++) {
			if (n[j] % 2 == 1) {
				min = n[j];
				break;
			}
		}
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
		sc.close();
	}
}
