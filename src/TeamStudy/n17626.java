package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n17626 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n == Math.pow(i, 2)) {
				answer = 1;
				System.out.println(answer);
				return;
			}
		}
		for (int i = 1; i <= Math.sqrt(n); i++) {
			for (int j = 1; j <= Math.sqrt(n); j++) {
				if (n == Math.pow(i, 2) + Math.pow(j, 2)) {
					answer = 2;
					System.out.println(answer);
					return;
				}
			}
		}
		for (int i = 1; i <= Math.sqrt(n); i++) {
			for (int j = 1; j <= Math.sqrt(n); j++) {
				for (int k = 1; k <= Math.sqrt(n); k++) {
					if (n == Math.pow(i, 2) + Math.pow(j, 2) + Math.pow(k, 2)) {
						answer = 3;
						System.out.println(answer);
						return;
					}
				}
			}
		}
		for (int i = 1; i <= Math.sqrt(n); i++) {
			for (int j = 1; j <= Math.sqrt(n); j++) {
				for (int k = 1; k <= Math.sqrt(n); k++) {
					for (int x = 1; x <= Math.sqrt(n); x++) {
						if (n == Math.pow(i, 2) + Math.pow(j, 2) + Math.pow(k, 2) + Math.pow(x, 2)) {
							answer = 4;
							System.out.println(answer);
							return;
						}
					}
				}
			}
		}

	}
}
