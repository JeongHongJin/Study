package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 출처 :https://steady-coding.tistory.com/56

public class n1202 {
	static class Node {
		int weight, val;

		Node(int weight, int val) {
			this.weight = weight;
			this.val = val;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Node[] node = new Node[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			node[i] = new Node(M, V);
		}
		Arrays.sort(node, new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				if (n1.weight == n2.weight) {
					return n2.val - n1.val;
				}
				return n1.weight - n2.weight;
			}
		});
		int[] w = new int[k];
		for (int i = 0; i < k; i++) {
			w[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(w);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long sum = 0;

		for (int i = 0, j = 0; i < k; i++) {
			while (j < n && node[j].weight <= w[i]) {
				pq.offer(node[j++].val);
			}
			if (!pq.isEmpty()) {
				sum += pq.poll();
			}
		}
		System.out.println(sum);
	}

}