package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class n17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			// 스택에 인덱스 값이 존재하는 경우
			// 현재 값이 스택의 맨 위 인덱스가 가리키는 arr 값보다 큰 경우
			// stack 원소를 pop하고
			// 해당 pop된 인덱스가 가르키는 arr 값을 현재 arr 값으로 변경
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			// 스택은 인덱스 값을 저장
			stack.push(i);
		}
		// 스택의 모든 원소를 pop 하면서 해당 인덱스의 value를
		// -1로 초기화
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);

	}
}
