package AlgoPuzzle68;

import java.io.IOException;

public class Q6_collatzConjecture {
	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= 10000; i++) {
			boolean flag = false;
			if (i % 2 == 0) {
				int now = i * 3 + 1;
				while (now != 1) {
					if (now % 2 == 0) {
						now /= 2;
					} else {
						now = now * 3 + 1;
					}
					if (now == i) {
						flag = true;
						break;
					}
				}
			}
			if (flag) {
				System.out.print(i + " ");
			}
		}
	}
}
