package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		System.out.print("<");
		while (list.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				int a = list.remove(0);
				list.add(a);
			}
			int answer = list.get(0);
			list.remove(0);
			System.out.print(answer+", ");
		}
		System.out.print(list.get(0));
		System.out.print(">");

	}
}
