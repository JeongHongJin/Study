package TeamStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class n10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		while (N > 0) {
			N--;
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_front":
				q.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				q.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.pollFirst()).append("\n");
				}
				break;
			case "pop_back":
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.pollLast()).append("\n");
				}
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				if (q.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "front":
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.getFirst()).append("\n");
				}
				break;
			case "back":
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.getLast()).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
