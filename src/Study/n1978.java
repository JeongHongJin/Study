package Study;

import java.util.Scanner;

public class n1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int answer = 0;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		for (int x = 0; x < N; x++) {
			flag = false;
			if (num[x] == 2) {
				answer++;
			} else if (num[x] > 2) {
				for (int j = 2; j < num[x]; j++) {
					if (num[x] % j == 0) {
						flag = true;
						break;
					} else
						flag = false;
				}
				if (flag == false) {
					answer++;
				}
			}

		}
		System.out.println(answer);
		sc.close();
	}
}
