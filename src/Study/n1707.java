package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 참고 및 출처: 유헤/김데브 개발 일기
public class n1707 {
	static int v, e;
	static int red = 1, blue = -1;
	static ArrayList<Integer>[] map;
	static int[] color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			map = (ArrayList<Integer>[]) new ArrayList[v + 1];
			color = new int[v + 1];
			boolean flag = false;
			for (int j = 1; j <= v; j++) {
				map[j] = new ArrayList<Integer>();
			}
			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				map[start].add(end);
				map[end].add(start);
			}
			for (int j = 1; j <= v; j++) {
				if (color[j] == 0) {
					flag = Search(j, 1);
				}
			}
			for (int j = 1; j <= v; j++) {
				for (int x : map[j]) {
					if (color[j] == color[x]) {
						flag = false;
					}
				}
			}
			if (flag) {
				sb.append("YES").append('\n');
			} else {
				sb.append("NO").append('\n');
			}

		}
		System.out.println(sb);
	}

	static boolean Search(int x, int cnt) {
		color[x] = cnt;
		for (int i : map[x]) {
			if (color[i] == 0) {
				if (Search(i, 3 - cnt) == false) {
					return false;
				}
			}
		}
		return true;
	}
}
