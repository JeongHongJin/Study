package Algo.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2668 {
	static int n;
	static ArrayList<Integer> list;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		list = new ArrayList<>();
		visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			visit[i] = true;
			dfs(i, i, arr); // 자기 자신이 목표
			visit[i] = false;
		}
		sb.append(list.size()).append('\n');
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int start, int goal, int[] arr) {
		if (!visit[arr[start]]) {
			visit[arr[start]] = true;
			dfs(arr[start], goal, arr);
			visit[arr[start]] = false;
		}
		if (arr[start] == goal) // 자기 자신을 찾은경우
			list.add(goal);
	}
}
