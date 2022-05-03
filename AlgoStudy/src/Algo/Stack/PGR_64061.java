package Algo.Stack;

import java.util.Stack;

public class PGR_64061 {
	class Solution {
		public int solution(int[][] board, int[] moves) {
			int answer = 0;
			Stack<Integer>[] boardStack = new Stack[board[0].length];
			for (int i = 0; i < board[0].length; i++) {
				boardStack[i] = new Stack<>();
			}
			for (int i = 0; i < board[0].length; i++) {
				for (int j = board.length - 1; j >= 0; j--) {
					if (board[j][i] > 0)
						boardStack[i].push(board[j][i]);
				}
			}
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < moves.length; i++) {
				if (boardStack[moves[i] - 1].isEmpty())
					continue;
				if (stack.isEmpty()) {
					stack.push(boardStack[moves[i] - 1].pop());
				} else {
					int peek = stack.peek();
					int doll = boardStack[moves[i] - 1].pop();
					if (peek == doll) {
						stack.pop();
						answer += 2;
					} else
						stack.push(doll);
				}
			}
			return answer;
		}
	}
}
