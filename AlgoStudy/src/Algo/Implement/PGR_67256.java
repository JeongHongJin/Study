package Algo.Implement;

public class PGR_67256 {
	class Solution {
		class Node {
			int x;
			int y;

			Node(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		public String solution(int[] numbers, String hand) {
			String answer = "";
			Node left = new Node(0, 0);
			Node right = new Node(0, 2);
			Node[] position = { new Node(0, 1), new Node(3, 0), new Node(3, 1), new Node(3, 2), new Node(2, 0),
					new Node(2, 1), new Node(2, 2), new Node(1, 0), new Node(1, 1), new Node(1, 2) };
			for (int i = 0; i < numbers.length; i++) {
				int num = numbers[i];
				Node now = position[num];
				if (num == 1 || num == 4 || num == 7) {
					left = position[num];
					answer += "L";
					continue;
				}
				if (num == 3 || num == 6 || num == 9) {
					right = position[num];
					answer += "R";
					continue;
				}
				if (Math.abs(now.x - left.x) + Math.abs(now.y - left.y) < Math.abs(now.x - right.x)
						+ Math.abs(now.y - right.y)) {
					answer += "L";
					left = position[num];
				} else if (Math.abs(now.x - left.x) + Math.abs(now.y - left.y) > Math.abs(now.x - right.x)
						+ Math.abs(now.y - right.y)) {
					answer += "R";
					right = position[num];
				} else {
					if (hand.equals("left")) {
						answer += "L";
						left = position[num];
					} else {
						answer += "R";
						right = position[num];
					}
				}

			}
			return answer;
		}
	}
}
