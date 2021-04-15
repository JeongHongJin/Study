package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class n10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new LinkedList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			if (s.equals("push")) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			if (s.equals("front")) {
				if (q.peek() != null) {
					sb.append(q.peek()).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
			}
			if (s.equals("back")) {
				if (q.peekLast() != null) {
					sb.append(q.peekLast()).append('\n');
				} else {
					sb.append(-1).append('\n');
				}

			}
			if (s.equals("size")) {
				sb.append(q.size()).append('\n');
			}
			if (s.equals("empty")) {
				if (q.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			}
			if (s.equals("pop")) {
				if (q.size() > 0) {
					sb.append(q.pop()).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
			}
		}
		System.out.println(sb);
	}
}
