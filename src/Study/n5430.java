package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class n5430 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			String cmd = br.readLine();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			while (st.hasMoreTokens())
				q.offer(Integer.parseInt(st.nextToken()));
			ac(cmd, q);
		}
		System.out.println(sb);
	}

	static void ac(String cmd, LinkedList<Integer> q) {
		boolean go = true;
		for (char c : cmd.toCharArray()) {
			if (c == 'R') {
				go = !go;
				continue;
			}
			if (go) {
				if (q.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			} else {
				if (q.pollLast() == null) {
					sb.append("error\n");
					return;
				}
			}
		}
		ans(q, go);
	}

	static void ans(LinkedList<Integer> q, boolean go) {
		sb.append('[');
		if (q.size() > 0) {
			if (go) {
				sb.append(q.pollFirst());
				while (!q.isEmpty()) {
					sb.append(',').append(q.pollFirst());
				}
			} else {
				sb.append(q.pollLast());
			}
			while (!q.isEmpty()) {
				sb.append(',').append(q.pollLast());
			}
		}
		sb.append(']').append('\n');
	}
}
