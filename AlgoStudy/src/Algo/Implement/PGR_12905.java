package Algo.Implement;

public class PGR_12905 {
	public int solution(int[][] board) {
		int answer = 0;
		int r = board.length;
		int c = board[0].length;
		if (r == 1 && c == 1) {
			if (board[0][0] == 0)
				return 0;
			else
				return 1;
		}
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (board[i][j] != 0) {
					board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
				}
				answer = Math.max(board[i][j], answer);
			}
		}
		return (int) Math.pow(answer, 2);
	}
}
