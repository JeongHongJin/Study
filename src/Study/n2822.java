package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class n2822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		int[] arr = new int[8];
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			list.add(num);
		}
		Arrays.sort(arr);
		int val = arr[2];
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<8;i++) {
			if(list.get(i)>val) {
				sum+=list.get(i);
				sb.append(i+1).append(' ');
			}
		}
		System.out.println(sum);
		System.out.println(sb);
	}
}
