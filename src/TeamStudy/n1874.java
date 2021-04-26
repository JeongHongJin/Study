package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class n1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int x = 0;

		while (N > 0) {
			N--;
			int val = Integer.parseInt(br.readLine());

			if (val > x) {
				for (int i = x + 1; i <= val; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				x = val;
			} else if (stack.peek() != val) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb);
	}
}
