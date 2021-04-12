package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
//리스트는 결국 시간조과, 큐는 시간 안의로 들어온다
public class n18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			if (s.equals("push")) {
				int n = Integer.parseInt(st.nextToken());
//				q.offer(n);
				list.add(n);
			}
			if (s.equals("front")) {
//				if (q.peek() != null) {
//					sb.append(q.peek()).append('\n');
//				} else {
//					sb.append(-1).append('\n');
//				}
				if (list.size() > 0) {
					sb.append(list.get(0)).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
			}
			if (s.equals("back")) {
//				if (q.peekLast() != null) {
//					sb.append(q.peekLast()).append('\n');
//				} else {
//					sb.append(-1).append('\n');
//				}
				if (list.size() > 0) {
					sb.append(list.get(list.size()-1)).append('\n');
				} else {
					sb.append(-1).append('\n');
				}

			}
			if (s.equals("size")) {
				sb.append(list.size()).append('\n');
//				sb.append(q.size()).append('\n');
			}
			if (s.equals("empty")) {
//				if (q.isEmpty()) {
//					sb.append(1).append('\n');
//				} else {
//					sb.append(0).append('\n');
//				}
				if (list.size() == 0) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
			}
			if (s.equals("pop")) {
//				if (q.size() > 0) {
//					sb.append(q.pop()).append('\n');
//				} else {
//					sb.append(-1).append('\n');
//				}
				if (list.size() > 0) {
					sb.append(list.remove(0)).append('\n');
				} else {
					sb.append(-1).append('\n');
				}
			}
		}
		System.out.println(sb);
	}
}
