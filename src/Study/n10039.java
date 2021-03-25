package Study;

import java.util.Scanner;

public class n10039 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			a[i] = sc.nextInt();
			if(a[i]<40) {
				sum += 40;
			}else sum += a[i];
		}
		System.out.println(sum/5);
		sc.close();
	}
}
