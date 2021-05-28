package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1074 {
	static int n;
	static int num = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, n);
		search(r, c, size);
		System.out.println(num);
	}

	static void search(int r, int c, int size) {
		if (size == 1) {
			return;
		}
		// 2,1,3,4분면
		if (r < size / 2 && c < size / 2) {
			search(r, c, size / 2);
		} else if (r < size / 2 && c >= size / 2) {
			num += size * size / 4;
			search(r, c - size / 2, size / 2);
		} else if (r >= size / 2 && c < size / 2) {
			num += (size * size / 4) * 2;
			search(r - size / 2, c, size / 2);
		} else {
			num += (size * size / 4) * 3;
			search(r - size / 2, c - size / 2, size / 2);
		}
	}
}
