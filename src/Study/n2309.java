package Study;

import java.util.Arrays;
import java.util.Scanner;

public class n2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			height[i] = sc.nextInt();
			sum += height[i];
		}
		sum -= 100;
		Arrays.sort(height);
		loop:
		for (int j = 0; j < 9; j++) {
			for (int k = j + 1; k < 9; k++) {
				if (sum == height[j] + height[k]) {
					height[j] = 0;
					height[k] = 0;
					break loop;
				}
			}
		}
		Arrays.sort(height);
		for (int x = 2; x < height.length; x++) {
			System.out.println(height[x]);
		}
		sc.close();
	}
}
