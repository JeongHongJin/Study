package Algo.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

//출처: https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-2170-%EC%84%A0-%EA%B8%8B%EA%B8%B0-java
public class BOJ_2170 {
	static class Node {
		long x;
		long y;

		Node(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			long x = Long.parseLong(str[0]);
			long y = Long.parseLong(str[1]);
			list.add(new Node(x, y));
		}
		list.sort(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if (o1.x > o2.x) {
					return 1;
				} else if (o1.x == o2.x) {
					if (o1.y > o2.y) {
						return 1;
					}
				}
				return -1;
			}
		});
		long x = list.get(0).x;
		long y = list.get(0).y;
		long sum = y - x;

		for (int i = 1; i < list.size(); i++) {
			long nx = list.get(i).x;
			long ny = list.get(i).y;
			if (x <= nx && ny <= y) { // 포함된경우
				continue;
			} else if (nx < y) { // 시작점은 내부에 존재하지만 y 확장
				sum += ny - y;
			} else { // 새로운 선분
				sum += ny - nx;
			}
			x = nx;
			y = ny;
		}
		System.out.println(sum);
	}
}
