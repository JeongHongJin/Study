package Algo.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2263 {
	static int n, idx = 0;
	static int[] in, post, pre;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		in = new int[n];
		pre = new int[n];
		post = new int[n];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(str[i]);
		}
		str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			post[i] = Integer.parseInt(str[i]);
		}
		search(0, n - 1, 0, n - 1);

		for (int now : pre) {
			sb.append(now).append(' ');
		}
		System.out.println(sb);
	}

	public static void search(int inStart, int inEnd, int postStart, int postEnd) {
		// 인오더 시작 <= 끝
		// 포스트오더 시작 <= 끝
		if (inStart <= inEnd && postStart <= postEnd) {

			// 포스트 오더의 가장 마지막이 루트 노드
			pre[idx++] = post[postEnd];

			int postStart2 = inStart;

			// 인오더에서 루트 노드 위치 찾는다.
			for (int i = inStart; i <= inEnd; i++) {
				if (in[i] == post[postEnd]) {
					postStart2 = i;
					break;
				}
			}
			// 왼쪽 자식 트리
			search(inStart, postStart2 - 1, postStart, postStart + postStart2 - inStart - 1);
			// 오른쪽 자식 트리
			search(postStart2 + 1, inEnd, postStart + postStart2 - inStart, postEnd - 1);
		}
	}
}
