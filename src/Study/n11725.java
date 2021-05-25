package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n11725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		// 그래프 인접 리스트로 입력
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[x].add(y);
			list[y].add(x);
		}
		// 부모값
		int[] parents = new int[n + 1];
		// 부모 노드 찾기 DFS
		Search(list, parents, n, 1, 0);

		for (int i = 2; i <= n; i++)
			System.out.println(parents[i]);
	}

	static void Search(ArrayList<Integer>[] list, int[] parents, int n, int start, int parent) {
		parents[start] = parent;
		for (int i : list[start]) {
			if (i != parent)
				Search(list, parents, n, i, start);
		}
	}
}
