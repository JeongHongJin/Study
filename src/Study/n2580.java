package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//출처 : stranger 블로그
public class n2580 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0, 0);
	}

	static void sudoku(int row, int col) {
		// 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 검사
		if (col == 9) {
			sudoku(row + 1, 0);
			return;
		}
		// 행과 열이 모두 채워졌을 경우 출력 후 종료
		if (row == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			return;
		}
		// 해당 위치가 0 이라면 1~9 중 가능한 수 탐색
		if (map[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (possibility(row, col, i)) {
					map[row][col] = i;
					sudoku(row, col + 1);
				}
			}
			map[row][col] = 0;
			System.exit(0);
		}
		sudoku(row, col + 1);
	}

	static boolean possibility(int row, int col, int val) {

		// 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 확인
		for (int i = 0; i < 9; i++) {
			if (map[row][i] == val) {
				return false;
			}
		}
		// 같은 열에 있는 원소들 중 겹치는 행 원소가 잇는지 확인
		for (int i = 0; i < 9; i++) {
			if (map[i][col] == val) {
				return false;
			}
		}
		// 3*3 칸에 중복되는 우너소가 있는지 검사
		int set_row = (row / 3) * 3;
		int set_col = (col / 3) * 3;

		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (map[i][j] == val) {
					return false;
				}
			}
		}
		// 중복이 없는 경우 true를 반환
		return true;
	}
}
