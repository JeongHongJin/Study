package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n9663 {
	static int n;
	static int[] arr;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		nQueen(0);
		System.out.println(cnt);
	}

	static void nQueen(int depth) {
		// 모든 원소를 다채운 상태면 cnt 증가 및 리턴
		if (depth == n) {
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[depth] = i;
			// 놓을 수 있는 위치일 경우 재귀호출
			if (Possibility(depth)) {
				nQueen(depth + 1);
			}
		}
	}

	static boolean Possibility(int col) {
		for (int i = 0; i < col; i++) {
			// 같은 행,열 체크
			if (arr[col] == arr[i])
				return false;
			// 대각선 체크
			// 열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우이다.
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
				return false;
		}
		return true;
	}
}
