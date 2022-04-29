package Algo.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_13219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] point;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			point = new int[3];
			point[0] = Integer.parseInt(st.nextToken());
			point[1] = Integer.parseInt(st.nextToken());
			point[2] = Integer.parseInt(st.nextToken());
			double p = (point[0] / 100.0) * 360.0;
			double x = point[1] - 50;
			double y = point[2] - 50;
			double tmp = 0;
			if (50 < Math.sqrt(Math.pow(y, 2) + Math.pow(x, 2))) {
				sb.append('#').append(t).append(' ').append(0).append('\n');
				continue;
			}
			tmp = 90 - (Math.atan2(y, x) * 180.0 / Math.PI);
			if (tmp < 0)
				tmp += 360;
			if (p > tmp)
				sb.append('#').append(t).append(' ').append(1).append('\n');
			else
				sb.append('#').append(t).append(' ').append(0).append('\n');
		}
		System.out.println(sb);
	}
}
